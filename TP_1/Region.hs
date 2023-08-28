module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import Link
import City
import Quality
import Point
import Tunel


data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []


foundR :: Region -> City -> Region
foundR region@(Reg cities links tunels) city | not (citiesInR region [city]) = Reg (city : cities) links tunels
                                             | otherwise = error "La ciudad ya existe en la region."

linkedR :: Region -> City -> City -> Bool 
linkedR region@(Reg _ links _) c1 c2 | citiesInR region [c1, c2] = any (linksL c1 c2) links
                                     | otherwise = error "Alguna de las ciudades no existen en la region."

linkR :: Region -> City -> City -> Quality -> Region 
linkR region@(Reg cities links tunels) c1 c2 q | citiesInR region [c1, c2]  = Reg cities (newL c1 c2 q : links) tunels
                                               | otherwise = error "Las ciudades no existen."

tunelR :: Region -> [City] -> Region 
tunelR region@(Reg cs links tunels) cities | validC && validT = Reg cs links (newT (getLinks links cities) : tunels)
                                           | otherwise = error "Error al generar el tunel."
                                             where validC = citiesInR region cities && length cities > 1 
                                                   validT = all (\x -> availableCapacityForR region (fst x) (snd x) > 0) (zip cities (tail cities))
                                                
                                                
connectedR :: Region -> City -> City -> Bool
connectedR region@(Reg _ _ tunels) c1 c2 | citiesInR region [c1, c2] = any (connectsT c1 c2) tunels
                                         | otherwise = error "Alguna de las ciudades no existe en la region."

delayR :: Region -> City -> City -> Float
delayR region@(Reg _ links tunels) c1 c2 | citiesInR region [c1, c2] && connectedR region c1 c2 = delayT tunel 
                                         | otherwise = error "Las ciudades no existen o no estan conectadas."
                                             where tunel = head [x | x <- tunels, connectsT c1 c2 x]

availableCapacityForR :: Region -> City -> City -> Int
availableCapacityForR region@(Reg _ links tunels) c1 c2 | citiesInR region [c1, c2] && linkedR region c1 c2 = capacityL link - tunnelsOccuping tunels link
                                                        | otherwise = error "Las ciudades no existen o no estan conectadas."
                                                            where link = findLink links c1 c2

tunnelsOccuping :: [Tunel] -> Link -> Int
tunnelsOccuping [] link = 0
tunnelsOccuping tunels link = length [x | x <- tunels, usesT link x]

getLinks :: [Link] -> [City] -> [Link]
getLinks _ [] = error "No hay ciudades."
getLinks _ [_] = error "No hay suficientes ciudades."
getLinks links [x, y] = [findLink links x y]
getLinks links (x:y:xs) = findLink links x y : getLinks links (y:xs)

findLink :: [Link] -> City -> City -> Link
findLink [] _ _ = error "No existe el link."
findLink (x:xs) c1 c2
    | linksL c1 c2 x = x
    | otherwise = findLink xs c1 c2

citiesInR :: Region -> [City] -> Bool
citiesInR region = all (cityInR region)
   where cityInR (Reg cities _ _) city = city `elem` cities

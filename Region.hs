module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import Link
import City
import Quality
import Point
import Tunel
import Data.ByteString (find)



data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []


foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR region@(Reg cities links tunels) city | not (cityInR region city) = Reg (city : cities) links tunels
                                             | otherwise = error "La ciudad ya existe en la region"

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR region@(Reg _ links _) c1 c2 | citiesInR region [c1, c2] = any (linksL c1 c2) links-- foldr (\x acc -> acc || linksL c1 c2 x) False links
                                     | otherwise = error "alguna de las ciudades no existe en la region"

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR region@(Reg cities links tunels) c1 c2 q | citiesInR region [c1, c2] && not (linkedR region c1 c2) = Reg cities (newL c1 c2 q : links) tunels
                                               | otherwise = error "Las ciudades no existen o ya estan enlazadas"

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg cs links tunels) cities | validC && validT && connectedR region (head cities) (last cities) = Reg cs links (newT (getLinks links cities) : tunels) -- Hay que hacer una lista de links y con eso crear el tunel
                                           | otherwise = error "Las ciudades no existen o no estan enlazadas o no hay capacidad suficiente"
                                             where validC = citiesInR region cities && length cities > 1 
                                                   validT = all (\x -> availableCapacityForR region (fst x) (snd x) > 0) (zip cities (tail cities))
                                                
                                                
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR region@(Reg _ _ tunels) c1 c2 | citiesInR region [c1, c2] = any (connectsT c1 c2) tunels
                                         | otherwise = error "Alguna de las ciudades no existe en la region"

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region@(Reg _ links tunels) c1 c2 | citiesInR region [c1, c2] && linkedR region c1 c2 = delayT tunel 
                                         | otherwise = error "Las ciudades no existen o no estan conectadas"
                                             where tunel = head [x | x <- tunels, connectsT c1 c2 x]

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region@(Reg _ links tunels) c1 c2 | citiesInR region [c1, c2] && linkedR region c1 c2 = capacityL link - tunnelsOccuping tunels link
                                                        | otherwise = error "Las ciudades no existen o no estan conectadas"
                                                            where link = findLink links c1 c2

tunnelsOccuping :: [Tunel] -> Link -> Int
tunnelsOccuping [] link = 0
tunnelsOccuping tunels link = length [x | x <- tunels, usesT link x]

getLinks :: [Link] -> [City] -> [Link]
getLinks _ [] = error "No hay ciudades"
getLinks _ [_] = error "No hay suficientes ciudades"
getLinks links [x, y] = [findLink links x y]
getLinks links (x:y:xs) = findLink links x y : getLinks links (y:xs)

findLink :: [Link] -> City -> City -> Link
findLink [] _ _ = error "No existe el link"
findLink (x:xs) c1 c2
    | linksL c1 c2 x = x
    | otherwise = findLink xs c1 c2

cityInR :: Region -> City -> Bool -- indica si la ciudad pertenece a la región
cityInR (Reg cities links tunels) city = city `elem` cities

citiesInR :: Region -> [City] -> Bool
citiesInR region = foldr (\x acc -> acc && cityInR region x) True

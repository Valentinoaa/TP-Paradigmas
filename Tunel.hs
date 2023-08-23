module Tunel ( Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality
import Point

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun -- Verificar si los links se la bancan

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) = (enPuntas c1 c2 links) && not ((inMiddle c1 links) || (inMiddle c2 links)) -- Esto es horrible corregir

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = foldr (\x acc -> acc || x == link) False links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = foldr (\x acc -> delayL x + acc) 0 links

inMiddle :: City -> [Link] -> Bool
inMiddle c1 links = foldr (\x acc -> acc || connectsL c1 x) False ls  -- Me declaro fan de foldr CHECKEAR!!!!
   where ls = (tail . init) links

-- Cambiar nombre (lo puse así para que se entienda)
enPuntas :: City -> City -> [Link] -> Bool
enPuntas c1 c2 links = connectsL c1 (head links) && connectsL c2 (last links) || connectsL c1 (last links) && connectsL c2 (head links)

availableCapacity :: [Link] -> Bool
availableCapacity links = foldr (\x acc -> acc && capacityL x > 0) False links
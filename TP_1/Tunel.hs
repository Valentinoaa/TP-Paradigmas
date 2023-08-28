module Tunel ( Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality
import Point

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link]-> Tunel
newT = Tun -- Verificar si los links se la bancan (o hacerlo en region)

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conceta estas dos ciudades distintas
connectsT c1 c2 (Tun links) = enPuntas c1 c2 links
                  where enPuntas c1 c2 links = connectsL c1 (head links) && connectsL c2 (last links) || connectsL c1 (last links) && connectsL c2 (head links)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = foldr (\x acc -> delayL x + acc) 0 links
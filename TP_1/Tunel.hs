module Tunel ( Tunel, newT, connectsT, usesT, delayT)
   where

import Link
import City
import Quality
import Point

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link]-> Tunel
newT = Tun 

connectsT :: City -> City -> Tunel -> Bool 
connectsT c1 c2 (Tun links) = atEnds c1 c2 links
                  where atEnds c1 c2 links = connectsL c1 (head links) && connectsL c2 (last links) || connectsL c1 (last links) && connectsL c2 (head links)

usesT :: Link -> Tunel -> Bool 
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float
delayT (Tun links) = foldr (\x acc -> delayL x + acc) 0 links
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link

data Tunel = Tun [Link] deriving (Eq, Show)

[a-b, b-c, c-d] -> a<->d

validTunel :: [Link] -> Bool
validTunel [] = False
validTunel links = 

newT :: [Link] -> Tunel
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = 

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link


delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
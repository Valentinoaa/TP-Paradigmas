module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link

data Tunel = Tun [Link] deriving (Eq, Show)

connectsCity :: Link -> Link -> Bool
connectsCity (Lin city1 city2 _) link2 = connectsL city1 link2 || connectsL city2 link2

city1 = newC "la matanza" (newP 4 5)

city2 = newC "keko" (newP 5 6)

city3 = newC "ilo" (newP 6 7)

l1 = newL city1 city2 (newQ "alta" 2 0.5)
l2 = newL city2 city3 (newQ "alta" 2 0.5)




-- newT :: [Link] -> Tunel
-- newT links = Tun links

-- connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
-- connectsT city1 city2 (Tun links) = 

-- usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link


-- delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
module Link (Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality
import Point

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 _) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin city3 city4 _) = (city1 == city3 && city2 == city4) || (city1 == city4 && city2 == city3)

capacityL :: Link -> Int
capacityL (Lin _ _ qua) = capacityQ qua

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ qua) = delayQ qua

t = [newL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5) == Lin (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5),
     connectsL (newC "la matanza" (newP 4 5)) (newL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5)),
     linksL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5)),
     capacityL (newL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5)) == 2,
     delayL (newL (newC "la matanza" (newP 4 5)) (newC "carlos" (newP 4 5)) (newQ "alta" 2 0.5)) == 0.5]
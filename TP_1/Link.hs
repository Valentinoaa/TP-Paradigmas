module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality
import Point

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link 
newL = Lin

connectsL :: City -> Link -> Bool   
connectsL city (Lin city1 city2 _) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool
linksL city1 city2 (Lin city3 city4 _) = (city1 == city3 && city2 == city4) || (city1 == city4 && city2 == city3)

capacityL :: Link -> Int
capacityL (Lin _ _ qua) = capacityQ qua

delayL :: Link -> Float 
delayL (Lin c1 c2 qua) = delayQ qua * distanceC c1 c2 
module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua

capacityQ :: Quality -> Int
capacityQ (Qua _ cap _) = cap

delayQ :: Quality -> Float 
delayQ (Qua _ _ del) = del

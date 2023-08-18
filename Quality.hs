module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ cap _) = cap

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ del) = del

t = [newQ "alta" 2 0.5 == Qua "alta" 2 0.5,
     capacityQ (newQ "alta" 2 0.5) == 2,
     delayQ (newQ "alta" 2 0.5) == 0.5]
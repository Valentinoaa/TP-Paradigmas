module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Link
import City
import Quality
import Point
import Tunel



data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Region -- espera los parametros o se inicializa vacio??? no se deberia inicializar con Reg [] [] []??

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities _ _) city = newR (city : cities) _ _ -- Hay que checkear si la ciudad ya está en la region (ez)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg _ links _) c1 c2 q = newR _ (newL c1 c2 q : links) _ -- Lo mismo con el link

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cts links tunels) cities = newR cts links (newT (getLinks cities) : tunels) -- Hay que hacer una lista de links y con eso crear el tunel 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunels) c1 c2 = foldr (\x acc -> acc || connectsT c1 c2 x) False tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) c1 c2 = foldr (\x acc -> acc || linksL c1 c2 x) False links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

validT :: Region -> [City] -> Bool
validT (Reg _ links _) [c1, c2] = linkedR links c1 c2 -- Ver como optimizar, atajar casos de listas con <1 ciudad
validT (Reg _ links _) (x:y:xs) = linkedR links x y && linkedR (y:xs) 

-- Mergear la validación de validar el tunel con el getLinks??
getLinks :: [City] -> [Link]


-- Uffff hay que checkear capacidad -> Es un problema pq los links en si no tienen contadores (Idea: usar usesT en cada link o algo parecido)
-- Preguntar a Emilio = Es válido hacer un tunel que ya existe?
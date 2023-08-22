module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Link
import City
import Quality
import Point
import Tunel



data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Region 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities _ _) city = newR (city : cities) _ _ -- Hay que checkear si la ciudad ya está en la region (ez)
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg _ links _) c1 c2 q = newR _ (newL c1 c2 q : links) _ -- Lo mismo con el link
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg _ _ tunels) = 
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
validT :: Region -> [City] -> Bool
validT (Reg cities links _) = 
-- Uffff hay que checkear capacidad -> Es un problema pq los links en si no tienen contadores (Idea: usar usesT en cada link o algo parecido)
-- Preguntar a Emilio = Es válido hacer un tunel que ya existe?
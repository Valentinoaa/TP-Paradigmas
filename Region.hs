module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Link
import City
import Quality
import Point
import Tunel



data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg -- espera los parametros o se inicializa vacio??? no se deberia inicializar con Reg [] [] []??

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities _ _) city = newR (city : cities) _ _ -- Hay que checkear si la ciudad ya está en la region (ez)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg _ links _) c1 c2 q = newR _ (newL c1 c2 q : links) _ -- Lo mismo con el link

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg _ links tunels) cities = newR _ links (newT (getLinks links cities) : tunels) -- Hay que hacer una lista de links y con eso crear el tunel 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunels) c1 c2 = foldr (\x acc -> acc || connectsT c1 c2 x) False tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) c1 c2 = foldr (\x acc -> acc || linksL c1 c2 x) False links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR x y z = 0.1

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR x y z = 1

-- Esta funcion no es necesaria. (Quizas) Depende de como manejemos construir el tunel
validT :: [Link] -> [City] -> Bool
validT links [c1, c2] = linkedR links c1 c2 -- Ver como optimizar, atajar casos de listas con <1 ciudad
validT links (x:y:xs) = linkedR links x y && validT links (y:xs) -- Esto está mal


-- 1 : Tratar de juntar las 2 funciones, 2 : que todos las funciones tengan de argumento link me parece horrible, ver como fixear
findLink :: [Link] -> City -> City -> Link
findLink  [] c1 c2 = 0 -- Raisear error (No existe el link)
findLink (x:xs) c1 c2 = if linksL c1 c2 x then x else findLink xs c1 c2 

getLinks :: [Link] -> [City] -> [Link]
getLinks links [x, y] = [findLink links x y]
getLinks links (x:y:xs) = findLink links x y : getLinks links (y:xs)


-- Uffff hay que checkear capacidad -> Es un problema pq los links en si no tienen contadores (Idea: usar usesT en cada link o algo parecido
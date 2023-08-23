module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import Link
import City
import Quality
import Point
import Tunel
import Data.ByteString (find)



data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] [] -- espera los parametros o se inicializa vacio??? no se deberia inicializar con Reg [] [] []?? -- Si 

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = Reg (city : cities) links tunels -- Hay que checkear si la ciudad ya está en la region (ez)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) c1 c2 q = Reg cities (newL c1 c2 q : links) tunels -- Lo mismo con el link

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cs links tunels) cities = Reg cs links (newT (getLinks links cities) : tunels) -- Hay que hacer una lista de links y con eso crear el tunel 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunels) c1 c2 = foldr (\x acc -> acc || connectsT c1 c2 x) False tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) c1 c2 = foldr (\x acc -> acc || linksL c1 c2 x) False links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR x y z = 0.1

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR x y z = 1

{-
-- Esta funcion no es necesaria. (Quizas) Depende de como manejemos construir el tunel
validT :: [Link] -> [City] -> Bool
validT links [c1, c2] = linkedR links c1 c2 -- Ver como optimizar, atajar casos de listas con <1 ciudad
validT links (x:y:xs) = linkedR links x y && validT links (y:xs) -- Esto está mal
-}

getLinks :: [Link] -> [City] -> [Link]
getLinks links [x, y] = [findLink links x y] -- Ver como optimizar, atajar casos de listas con <1 ciudad
getLinks links (x:y:xs) = findLink links x y : getLinks links (y:xs)

-- Tener 2 funciones para lo mismo es engorroso, ver como fixear

findLink :: [Link] -> City -> City -> Link
findLink [] c1 c2 = error "No existe el link"
findLink [x] c1 c2 = if linksL c1 c2 x then x else error "No existe el link"
findLink (x:y:xs) c1 c2 = if linksL c1 c2 x then x else findLink (y:xs) c1 c2

import Region 
import City
import Link
import Tunel
import Point 
import Quality

point1 = newP 4 4
point2 = newP 1 0

point3 = newP 4 5

test_point = [point1 /= point2, difP point1 point2 == 5]

city1 = newC "La Matanza" point1
city2 = newC "Berazategui" point2
city3 = newC "Florencio Varela" point3

test_city = [city1 /= city2, nameC city1 == "La Matanza", distanceC city1 city2 == 5]

quality1 = newQ "Cobre" 2 0.5

test_quality = [quality1 /= newQ "Cobre" 1 0.2, capacityQ quality1 == 2, delayQ quality1 == 0.5]

link1 = newL city1 city2 quality1
link2 = newL city2 city3 quality1

test_link = [link1 /= link2, connectsL city1 link1, linksL city1 city2 link1, capacityL link1 == 2, delayL link1 == 2.5]

tunel1 = newT [link1, link2]

test_tunel = [tunel1 /= newT [link1], usesT link1 tunel1, delayT tunel1 == (2.5 + sqrt 34 * 0.5)]

region1 = newR
regionCities = foundR (foundR (foundR region1 city1) city2) city3
regionLinks = linkR (linkR regionCities city1 city2 quality1) city2 city3 quality1
regionTunels = tunelR regionLinks [city1, city2, city3]

regionTunels2 = tunelR regionTunels [city1, city2]



test_region = [  
               linkedR regionTunels city1 city2, 
               not (linkedR regionTunels city1 city3), 
               linkedR regionTunels city2 city3, 
               delayR regionTunels city1 city2 == (2.5 + sqrt 34 * 0.5),
               availableCapacityForR regionTunels city1 city2 == 1,
               availableCapacityForR regionTunels2 city1 city2 == 0]

allTests = [test_point, test_city, test_quality, test_link, test_tunel, test_region]

# MoonFlowerProto

gradle and library versions: it is the same version as the sunflower project

### Execution Environment

Mac M1 Pro Sonoma 14.1  
Local Java 17  
Android Studio : Iguana 2023.2.1 Canary 7  
XCode : Version 15.0

### Original Sunflower Directory
#### Data DB  
**AppDatabase** : App Database  
**GardenPlanting** (Entity) : `garden_plantings` Table  
**Plant** (Entity) : `plant` Table (id(PK) foreignkey with garden_plantings -> id)  
**Converters** : convert calendar data to timestamp  
**GardenPlantingDao** : GardenPlanting Query  
**PlantDao** : Plant Query  
**PlantAndGardenPlantings**  
**SeedDatabaseWorker**  : using *`JetPack WorkManager`* + *`GSON`*  


#### Data Network
**UnsplashService** : Okhttp, Retorift  
**UnsplashSearchResponse** : network response  
**UnsplashPagingSource** : road data (using UnsplashService + *`JetPack Paging3`*)  
**UnsplashPhoto** : data class  
**UnsplashUser** : data class  
**UnsplashPhotoUrls** : data class    

#### Data Repository
**GardenPlantingRepository** : using GardenPlantingDao  
**PlantRepository** : using PlantDao  
**UnsplashRepository** : using UnsplashService  

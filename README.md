Page created by Kyle Gehrman 2014. 

TigerEye is an Android application that implements a creative visualization of GPS points through the use of an augmented reality interface over an Android device's camera view. The target audience is college freshmen, to be used as a tool to help them find academic buildings but any GPS points could be used for further implementation. 

Screenshots:
augmented reality view: http://imgur.com/RfMuMYW
map view: http://imgur.com/jYQWpHl

The project is available on GitHub and has a hard completion date of May 10 2014. 

Technologies used: Java, Android SDK, Eclipse, SQL, PHP, PHPMyAdmin, DroidAR, Fluid UI, JSON, XML and HTML

Hardware Components Used:
  -Android device with an API level of at least 14
  -Camera
  -GPS sensor
  -Orientation sensor
  -Internet connectivity via 3/4G or Wifi
  
Technical Summary 
	Android Tigereye is a mobile application that uses available geospatial information to create an augmented reality view that creatively displays geological points to a user. The application is a single .apk file that is comprised of several java classes and libraries in addition to .xml files that handle most application layer data that the user sees. 
	The main view of the application, the augmented reality view, is handled by the DROID-AR framework. This framework uses complex geometry to determine where to place objects that represent locations over a camera view. The locations are passed to the AR framework and the building icons are dynamically moved as the camera moves across the scene. Once the icons are no longer in the view, they disappear. 
	All locations are stored on an external SQL server. The retrieval of the information is handled by JSON on the application end and PHP on the database end. The application itself, through the use of java, can determine if the SQL database is no longer up to date and it will retrieve the locations and update the icons in the view. The values retrieved from the database will be saved as java fields, the application will not make use of an internal database.


Milestones:
24 March: 
  -working AR view with hard coded GPS points
  -working ‘proof of concept’ for the main AR view. 
31 March: 
  -external db loading points to AR view
  -implement the AR view using points that are retrieved from an external SQL database. 
  -shell of menu interface
  -create .xml pages and activities to be used as the basic interfaces for the application. 
  -create and update technical reference manual pertaining to the AR framework 
  -create and update user manual pertaining to AR framework and basic menu interface 
7 April: 
  -more complete interface
  -make design decisions about the visual aspects of the interfaces and create relevant menu options. 
  -take me back and forward db 
  -develop back end “take me forward” and “take me back” db.
  -update technical reference manual for the “take me _” portion. 
  -create descriptions for campus building and images to be used for forward and backwards. 
14 April: 
  -take me forward and back 
  -implement the interface’s that will handle the “take me forward” and “take me back” functionality. 
  -view in AR mode 
  -detailed viewing mode with images and information 
  -update Technical Reference Manual  

21 April: 
  -finalize the Technical Reference Manual 
  -finalize the User Manual 
  -develop authoring tool that allows for information to be easily pushed to the database. 
  -must allow for adding of new buildings and other location information. 
30 April: 
  -create and finalize one minute video about the application
  -video will demonstrate the AR view and the basic interfaces as well as give a basic definition of the functionality of the app.

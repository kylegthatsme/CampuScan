# TigerEye

Page created by Kyle Gehrman 2014.  <br>
Email Questions or Comments to: kgehrma@g.clemson.edu
<br> 
https://www.youtube.com/watch?v=Vw58fyrEXXU&feature=youtu.be
<br>
TigerEye is an Android application that implements a creative visualization of GPS points through the use of an augmented reality interface over an Android device's camera view. The target audience is college freshmen, to be used as a tool to help them find academic buildings but any GPS points could be used for further implementation. 

### Technical Summary
   Android Tigereye is a mobile application that uses available geospatial information to create an augmented reality view that creatively displays geological points to a user. The application is a single .apk file that is comprised of several java classes and libraries in addition to .xml files that handle most application layer data that the user sees. <br><br>
   The main view of the application, the augmented reality view, is handled by the DROID-AR framework. This framework uses complex geometry to determine where to place objects that represent locations over a camera view. The locations are passed to the AR framework and the building icons are dynamically moved as the camera moves across the scene. Once the icons are no longer in the view, they disappear. <br><br>
   All locations are stored on an external SQL server. The retrieval of the information is handled by JSON on the application end and PHP on the database end. The application itself, through the use of java, can determine if the SQL database is no longer up to date and it will retrieve the locations and update the icons in the view. The values retrieved from the database will be saved as java fields, the application will not make use of an internal database.

#### Screenshots: 
augmented reality view: http://imgur.com/RfMuMYW <br>
map view: http://imgur.com/jYQWpHl <br>

#### Technologies used: 
Java, Android SDK, Eclipse, SQL, PHP, PHPMyAdmin, DroidAR, Fluid UI, JSON, XML and HTML

#### Hardware Components Used: 
  -Android device with an API level of at least 14 <br>
  -Camera <br>
  -GPS sensor <br>
  -Orientation sensor <br>
  -Internet connectivity via 3/4G or Wifi <br>
  



###Milestones: 
####24 March: 
  -working AR view with hard coded GPS points <br>
  -working ‘proof of concept’ for the main AR view. <br>
####31 March: 
  -external db loading points to AR view<br>
  -implement the AR view using points that are retrieved from an external SQL database. <br>
  -shell of menu interface<br>
  -create .xml pages and activities to be used as the basic interfaces for the application. <br>
  -create and update technical reference manual pertaining to the AR framework <br>
  -create and update user manual pertaining to AR framework and basic menu interface <br>
####7 April: 
  -more complete interface<br>
  -make design decisions about the visual aspects of the interfaces and create relevant menu options. <br>
  -take me back and forward db <br>
  -develop back end “take me forward” and “take me back” db.<br>
  -update technical reference manual for the “take me _” portion. <br> 
  -create descriptions for campus building and images to be used for forward and backwards. <br>
####14 April: 
  -take me forward and back <br>
  -implement the interface’s that will handle the “take me forward” and “take me back” functionality. <br>
  -view in AR mode <br>
  -detailed viewing mode with images and information <br>
  -update Technical Reference Manual  <br>
####21 April: 
  -finalize the Technical Reference Manual <br>
  -finalize the User Manual <br>
  -develop authoring tool that allows for information to be easily pushed to the database. <br>
  -must allow for adding of new buildings and other location information. <br>
####30 April: 
  -create and finalize one minute video about the application <br>
  -video will demonstrate the AR view and the basic interfaces as well as give a basic definition of the functionality of the app. <br>

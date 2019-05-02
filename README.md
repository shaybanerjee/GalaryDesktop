<h1> Assignment 3 (Code found inside a3_starter_code/ directory)</h1> 
A interactive application that allows users to load, display images in a dynamic layout with their metadata.
A rating system is in place to allow users to rate, and filter images. 

<ul>
    <li> The application starts with an empty window, and the user can load an image by pressing "load" icon. </li> 
    <li> When an image is loaded, a thumbnail gets created (sized according to window), with a clickable image (to expand i a seperate window), a title, date, and stars to rate the image </li>
    <li> When exiting the application the current state of the application is saved </li>
    <li> Users can rate images by selecting number of stars, and filter the images based on the stars (3 star filter, will show images >= 3 stars) </li>
    <li> Both grid and list layout are supported and can be toggled using a button on the menu </li>
    <li> Dynamic layout -> When window resized, columns increase/decrease to fill space </li>
</ul>

The application can be run using ./gradlew run

<h1> Enhancements </h1>
No enhacements for this assignment. 

<h1> Developement Env </h1> 
Developed in java using jdk-10.0.1. 

<h1> Summary: </h1> 
<b> Load Icon: </b> Select to load a new image into the galary. <br> 
<b> Filter Stars: </b> Can select a number of starts to filter by. (Will show images with a rating >= filter value selected) <br> 
<b> Grid Layout Button </b> Can press to switch the layout of the galary to a Dynamic Grid Layout. <br> 
<b> List Layout Button </b> Can press to switch the layout of the galary to a Dynamic List Layout. <br> 
<b> Thumbnail Image </b> Can press on the image to open a window with the image scaled up. <br> 
<b> Thumbnail Stars </b> Can select a certain number of stars to rate the image out of 5. This will be used to filter. <br> 
<b> Thumbnail title </b> title of the image.<br> 
<b> Thumbnail Date </b> Date the image was created.<br> 
<b> Enhancement: </b> None. <br> 
<b> Dev environment: </b> Developed in java using jdk-10.0.1.   </br>
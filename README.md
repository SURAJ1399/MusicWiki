# MusicWiki
MusicWiki app using last.fm APIs built using kotlin for native android. It is based on MVVM pattern with dagger Hilt as dependency injection tools.
It helps to discover albums,artists and tracks based on different Genre. Overall its a wikipedia for Music


Download app Here 
https://github.com/SURAJ1399/MusicWiki/blob/master/app-debug.apk

## TECHNOLOGY AND LIBRARIES

KOTLIN,
DAGGER HILT,
JUNIT,
RETROFIT,
MVVM(Architecture Patern)




## Features

- Display the list of genres available. Genres are called tags in LastFm api. The list will
initially contain top 10 genres and when the user clicks on the expand button the entire
list is shown in the same screen.
- Clicking on the genre it should take the user to a page which contains information
regarding it. It should have a genre as the title, description of the genre.In the page it
should list top albums, top tracks and top artists as different sections.
- Each item listed under the album  has the cover image if available or a
default image, the title and artist name
- Each item listed under the artists has the cover image, if available or a
default image and the name
- Each item listed under tracks should has the cover image if available or a
default image, the title and artist name.

● Clicking on the item

○ Albums
■ It  display the cover image, title and the artist information. It 
also have  the description and the genres. Clicking on the genre it 
display the details about the genre, similar to the flow in the first screen.

○ Artists
■ It  display the image, title ,play count and followers, description, a
list of top tracks and top albums and the genres. Clicking on the genre it
 display the details about the genre, similar to the flow in the first
screen.

■ Clicking on the album should show its information.



<div class="row">
    <img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/a.png" width="30%">
<img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/b.png" width="30%">

  <img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/c.png" width="30%">
</div>
<div class="row">
    <img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/d.png" width="30%">
<img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/e.png" width="30%">

  <img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/f.png" width="30%">

</div>
<div class="row">
    <img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/g.png" width="30%">
<img src="https://github.com/SURAJ1399/MusicWiki/blob/master/mw/h.png" width="30%">

</div>


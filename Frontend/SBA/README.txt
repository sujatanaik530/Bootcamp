My GitHub: https://github.com/sujatanaik530/Bootcamp/tree/main/Frontend/SBA

I have created a website for a library (The Local Library).
From the home page, the user can navigate to
(1) Good Reads - a table with librarian-recommended books
(2) Patron Login - a login form for registered library patrons. Validations for email and password are present.
(3) Patron Registration - a form to register a person as a library patron. Validations for all required fields are present.
(4) Staff Login - a login page for library staff (placeholder)

The directroy structure:
SBA
|___.vscode
    |___settings.json 		(used by Visual Studio Code)
|___css
    |___styles.css 		(external stylesheet)
|___data
    |___result.json 		(JSON data which is in GoodReads.js)
|___images
    |___landing.jpg 		(image used on home page)
    |___texture.jpg 		(background used on all pages except the home page)
|___js
    |___GoodReads.js 		(JavaScript used by GoodReads.html)
    |___index.js 		(JavaScript used by index.html)
    |___PatronLogin.js 		(JavaScript used by PatronLogin.html)
    |___PatronRegistration.js 	(JavaScript used by PatronRegistration.html)
    |___StaffLogin.js 		(JavaScript used by StaffLogin.html)
|___GoodReads.html 		(HTML page displaying a table)
|___index.html 			(HTML home page)
|___PatronLogin.html 		(HTML login form page for existing patrons)
|___PatronRegistration.html	(HTML registration form page for new patrons)
|___README.txt 			(this file)
|___StaffLogin.html 		(HTML login page for library staff, just a placeholder)

I have used the following to create this website:
(1) HTML, CSS and JavaScript
(2) Bootstrap (CDN) for extra styling
(3) Google Font (@import) - 'Montserrat Alternates'
(4) Font Awesome (CDN) - for the home icon on all pages except the home page
(5) JSON - I have book data (spreadsheet -> CSV -> JSON) stored in JSON format (in GoodReads.js), which I parsed and displayed in a table. 

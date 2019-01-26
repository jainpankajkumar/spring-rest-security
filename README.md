# spring-rest-security
Secure rest services using basic spring security with custom accessdenied and loginfailer handlers

- Below are the user details configured in the code - 

1. User Name - employee  Password - employee
2. User Name - admin     Password - admin

- Below is the urls to access with employee role - 
    http://localhost:8080/home/employee
    
- Below is the urls to access with admin role -  
    http://localhost:8080/home/admin


- When employee url is access by admin user then access denied will be displayed as admin is not having employee role.
- When admin url is access by employee user then access denied will be displayed as employee is not having admin role.

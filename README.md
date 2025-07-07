# Wildlife Zoo Ticketing Management System

## Project Overview
The Wildlife Zoo Ticketing Management System is a web-based application designed to manage ticketing, animal records, and user roles (Admin, Staff, Customer) for a wildlife conservation zoo. The system streamlines ticket purchases, animal management, and staff administration, providing a user-friendly interface for all stakeholders.

## Features
- **User Authentication**: Separate login for Admin, Staff, and Customers.
- **Customer Registration**: New customers can register and manage their profiles.
- **Ticket Management**:
  - Customers can purchase, view, and cancel tickets.
  - Staff and Admin can view and update ticket statuses (e.g., mark as visited).
- **Animal Management**:
  - Admin and Staff can add, update, and delete animal records.
  - All users can view the animal directory.
- **Staff Management**: Admin can add, update, and remove staff members.
- **Role-Based Dashboards**: Custom dashboards for Admin, Staff, and Customers.
- **Responsive UI**: Modern, mobile-friendly interface using Bootstrap and custom CSS.

## Technologies Used
- **Java (Servlets, JSP)**
- **JSTL (JavaServer Pages Standard Tag Library)**
- **Apache Derby (JavaDB) Database**
- **JDBC**
- **HTML5, CSS3, JavaScript, Bootstrap**

## Project Structure
- `src/java/com/mvc/bean/` - JavaBeans for data models (Admin, Staff, Customer, Animal, Ticket)
- `src/java/com/mvc/controller/` - Servlets for handling requests (login, CRUD operations)
- `src/java/com/mvc/dao/` - Data Access Objects for database operations
- `src/java/com/mvc/util/` - Utility classes (e.g., DBConnection)
- `web/` - JSP pages, static assets (CSS, JS, images)
- `build.xml` - Ant build script

## Database Setup
- **Database**: Apache Derby (JavaDB)
- **Connection URL**: `jdbc:derby://localhost:1527/wildlife`
- **Username**: `app`
- **Password**: `app`
- **Driver**: `org.apache.derby.jdbc.ClientDriver`

> Ensure Apache Derby is running and the `wildlife` database is created with the required tables (CUSTOMER, STAFF, ADMIN, ANIMAL, TICKET).

## Setup Instructions
1. **Clone the Repository**
   ```
   git clone <repository-url>
   ```
2. **Database**
   - Start Apache Derby server.
   - Create the `wildlife` database and tables as per the data models.
3. **Build and Deploy**
   - Use NetBeans or any compatible IDE.
   - Open the project and build using the provided `build.xml` (Ant script).
   - Deploy to a servlet container (e.g., Apache Tomcat, GlassFish).
4. **Access the Application**
   - Open a browser and navigate to the deployed application's URL (e.g., `http://localhost:8080/WildlifeZooTicketingManagementSystem/web/index.jsp`).

## Usage
- **Home Page**: Select user type (Staff or Customer) to login.
- **Admin Panel**: Access via Admin login (URL or login page).
- **Customer**:
  - Register as a new user.
  - Login to buy tickets, view/manage tickets, and update profile.
- **Staff**:
  - Login to manage animals and tickets.
- **Admin**:
  - Login to manage staff, animals, and tickets.

## User Roles
- **Admin**: Full access to all modules (staff, animal, ticket management).
- **Staff**: Manage animals and tickets.
- **Customer**: Register, buy/cancel tickets, view animal directory.

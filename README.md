# IPL Auction System

A Java console application that simulates IPL player auctions with automated bidding between teams.

## Features

- **Live Player Auction**: Simulate real-time bidding with 5 random teams
- **Player Management**: Add, delete, and view players
- **Team Management**: Manage IPL teams and view rosters
- **Admin Panel**: Secure login and auction controls
- **Auction History**: Track IPL championship winners

## Requirements

- Java 8 or higher
- MySQL Server
- MySQL JDBC Driver

## Database Setup

1. Create database and tables:

```sql
CREATE DATABASE iplauction1;
USE iplauction1;

CREATE TABLE login_details (
    id_number INT PRIMARY KEY,
    name VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE player_details (
    player_id INT PRIMARY KEY AUTO_INCREMENT,
    player_name VARCHAR(100),
    player_type VARCHAR(50),
    team_name VARCHAR(50),
    base_price INT,
    is_available BOOLEAN DEFAULT 1
);

CREATE TABLE team_details (
    team_id INT PRIMARY KEY AUTO_INCREMENT,
    team VARCHAR(10),
    team_name VARCHAR(100)
);

CREATE TABLE win_details (
    team_name VARCHAR(100),
    year INT
);
```

2. Insert sample admin:
```sql
INSERT INTO login_details VALUES (1, 'Admin', 'password123');
```

3. Insert sample teams (Team IDs 11-20):
```sql
INSERT INTO team_details VALUES 
(11, 'MI', 'Mumbai Indians'),
(12, 'CSK', 'Chennai Super Kings'),
(13, 'RCB', 'Royal Challengers Bangalore');
-- Add more teams...
```

## Installation

1. Clone the repository
2. Update database credentials in `IPLAuction1.java` if needed:
```java
String dbURL = "jdbc:mysql://localhost:3306/iplauction1";
String dbUSER = "root";
String dbPASS = "";
```
3. Compile: `javac IPLAuction1.java`
4. Run: `java IPLAuction`

## How to Use

### Login
- Enter your admin ID and name
- Enter password when prompted

### Main Menu
- **Option 1**: Start player auction
- **Option 2**: View auction details
- **Option 0**: Exit

### Auction Details Menu
1. Show all teams
2. Show team players
3. Show available players
4. Show admin list
5. Show IPL winners
6. Add player
7. Add team
8. Delete player
9. Delete team

## How Auction Works

1. Select a player from available list
2. System simulates 5 teams bidding automatically
3. Bids increase from ₹2Cr to ₹20Cr across 5 rounds
4. Highest bidder wins the player
5. Player is assigned to winning team

## Technical Details

- **Multi-threading**: Simulates live bidding with delays
- **Stack**: Tracks and displays bid history
- **JDBC**: Connects to MySQL database

## Configuration

Default settings (change in code if needed):
- Database: `iplauction1`
- Host: `localhost:3306`
- User: `root`
- Password: empty

## License

Open source - MIT License

---

**Note**: Ensure MySQL is running and database is set up before starting the application.

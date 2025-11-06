import java.sql.*;
import java.util.*;

class DBConnect {
    // This class for JDBC connection...
    String driverName = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/iplauction1";
    String dbUSER = "root";
    String dbPASS = "";
    Connection con;
    DBConnect() throws Exception {
        Class.forName(driverName);
        con = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
    }
}

class MyStack{

    MyStack list[];
    int top=-1,size;
    
    String team;
    int bid;

    public MyStack(String team, int bid) {
        this.team = team;
        this.bid = bid;
    }

    public MyStack(int size) {
        list=new MyStack[size];
        this.size = size;
    }

    void push(MyStack x){

        if(top>=size-1){
            System.out.println("Stack Overflow");
        }else {
            top++;
            list[top]=x;
        }

    }

    void pop(){

        if(top==-1){
            System.out.println("Stack Underflow");
        }else {
            top--;
        }

    }

    void displayStack(){

        for(int i=top;i>=0;i--){
            System.out.println(list[i].team+" Bid for Rs."+list[i].bid+" Cr.");
            pop();
        }

    }

    int search(String search_team){
        
        if (top==-1) {
            return 0;
        }else{
            for(int i=top;i>=0;i--){
                if (list[i].team.equalsIgnoreCase(search_team)) {
                    return 1;
                }
            }
        }
        return 0;

    }

}

class MyThread extends Thread{

    MyStack s = new MyStack(5);
    MyStack obj;

    static String final_team;
    static int final_bid;

    public void run(){

        String random_team;
        int random_bid,count=1;

        try {

            for(int i=1;i<=5;i++){

                System.out.println();

                    do {
                        random_bid = randomBid(count);
                        random_team = IPLAuction.teamName(randomTeam());
                    } while (s.search(random_team)!=0);
    
                obj = new MyStack(random_team, random_bid);
                s.push(obj);
    
                System.out.print("Team :- "+random_team+"\tBid(Rs.) :- "+random_bid+" Cr. ");
    
                count++;
    
                for(int j=1;j<=3;j++){
                    System.out.print(".");
                    Thread.sleep(1000);
                }

                final_team = random_team;
                final_bid = random_bid;
            }
        } 

        catch(Exception e){
            // TODO: handle exception
        }

        System.out.println("\n---Final Auction Result---\n");
        s.displayStack();
        
    }

    static int randomTeam(){

        Random random = new Random();
        
        // Generate a random number between 11 and 20 inclusive
        int randomNumber = 11 + random.nextInt(10);
        return randomNumber;

    }

    static int randomBid(int count){

        Random random = new Random();

        if (count==1){
            // Generate a random number between 2 and 7
            int randomNumber = 2 + random.nextInt(5);
            return randomNumber;

        }
        else if (count==2){
            // Generate a random number between 5 and 8 inclusive
            int randomNumber = 5 + random.nextInt(4); 
            return randomNumber;

        }
        else if (count==3){
            // Generate a random number between 8 and 12 inclusive
            int randomNumber = 8 + random.nextInt(5);
            return randomNumber;

        }
        else if (count==4){
            // Generate a random number between 12 and 15 inclusive
            int randomNumber = 12 + random.nextInt(4);
            return randomNumber;

        }
        else{
            // Generate a random number between 15 and 20 inclusive
            int randomNumber = 15 + random.nextInt(6);
            return randomNumber;
        }

    }
}

class IPLAuction {

    static Scanner sc = new Scanner(System.in);
    PreparedStatement pst;
    DBConnect dc ; // DBConnect Class object, to access connection obj. in all methods..

    public IPLAuction() throws Exception{
        dc = new DBConnect();
    }

    static String teamName(int teamID) throws Exception{

        DBConnect dc =new DBConnect();
        String sql = "select team from team_details where team_id='"+teamID+"' ";
        PreparedStatement pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String teamName = rs.getString(1);
        return teamName;

    }

    boolean checkIdentity(int id,String name) throws Exception{

        String sql = "select * from login_details";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int temp = 0;

        while (rs.next()) {
            if ((rs.getInt(1)==id)&&(rs.getString(2).equalsIgnoreCase(name))) {
                temp = 1;
            }
        }
        if (temp==1) {
            return true;
        }else{
            return false;
        }

    }

    boolean verifyPassword() throws Exception{

        System.out.println();
        System.out.print("Enter ID Password :- ");
        String password = sc.nextLine();
        String sql = "select * from login_details";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int temp = 0;
        while (rs.next()) {
            if (rs.getString(3).equals(password)) {
                temp = 1;
            }
        }
        if (temp==1) {
            return true;
        }else{
            System.out.println("Wrong Password !!");
            return verifyPassword();
        }

    }

    boolean checkPlayer(int player_id) throws Exception{

        String sql = "select * from player_details where player_id = '"+player_id+"' ";
        int r = pst.executeUpdate(sql);
        if (r>0) {
            return true;
        }else{
            return false;
        }

    }

    void AuctionPlayer() throws Exception{

        System.out.println();
        System.out.println("---Verify Your Password---");
        verifyPassword();

        System.out.println();
        System.out.println("\t\t-----Avalible Player for Auction-----");

        String sql = "select player_id,player_name,player_type,base_price from player_details where is_available = 1";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        System.out.println("player_id\tbase_price(in Cr.)\tplayer_name\tplayer_type");
        System.out.println();
        while (rs.next()) {
            
            System.out.print(rs.getInt(1) +"\t\t\t");
            System.out.print(rs.getInt(4) +"\t\t");
            System.out.print(rs.getString(2) +"\t");
            System.out.println(rs.getString(3) +"\t");

        }


        System.out.println();
        System.out.print("Enter Player ID for Auction :- ");
        int playerID = sc.nextInt();
        sc.nextLine();

        String sql1 = "select * from player_details where player_id='"+playerID+"' ";
        ResultSet rs1 = pst.executeQuery(sql1);
        
        if (rs1.isBeforeFirst()) {
            String sql11 = "select player_name,player_type,base_price from player_details where player_id='"+playerID+"' ";
            ResultSet rs11 = pst.executeQuery(sql11);
            rs11.next();

            System.out.println();
            System.out.print("Auction Started For ,\n");
            System.out.println("Player\t:"+rs11.getString(1));
            System.out.println("Type\t:"+rs11.getString(2));
            System.out.println("Base Price\t:"+rs11.getInt(3)+" Cr.");
            System.out.println();

            MyThread mt = new MyThread();
            mt.start();
            mt.join();

            String sql2 = "select player_name from player_details where player_id='"+playerID+"'";
            ResultSet rs2 = pst.executeQuery(sql2);
            
            rs2.next();
            String p_name = rs2.getString(1);
            System.out.println("\n---Final Decision---");
            System.out.println("Player "+p_name+" is now in team "+MyThread.final_team+".");

            String sql3 = "update player_details set team_name='"+MyThread.final_team+"' ,is_available=0 where player_id='"+playerID+"' ";
            int r = pst.executeUpdate(sql3);
        }else{
            System.out.println("\nPlayer ID Not Found, try again !!");
        }
    }

    void AuctionDetails() throws Exception{
        System.out.println();
        
        int ch;
        do {
            System.out.println();
            System.out.println("\tAuction Details Menu");
            System.out.println("1 : Show All Teams Name");
            System.out.println("2 : Show Player Details of Particular Team");
            System.out.println("3 : Show Player which not in any Team");
            System.out.println("4 : Show Admin Details");
            System.out.println("5 : Show Winning History of IPL");
            System.out.println("6 : Add Player");
            System.out.println("7 : Add Team");
            System.out.println("8 : Delete Player");
            System.out.println("9 : Delete Team");

            System.out.println("0 : Exit");
            System.out.println();
            System.out.print("Enter which Auction Detail will be show :- ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    showAllTeam();
                    break;

                case 2:
                    showTeamDetails();
                    break;

                case 3:
                    playerNotInTeam();
                    break;

                case 4:
                    adminList();
                    break; 

                case 5:
                    winList();
                    break;

                case 6:
                    addPlayer();
                    System.out.println("Player added successfully");
                    break; 

                case 7:
                    addTeam();
                    System.out.println("Team added successfully");
                    break;

                case 8:
                    deletePlayer();
                    System.out.println("Player deleted successfully");
                    break; 

                case 9:
                    deleteTeam();
                    System.out.println("Team deleted successfully");
                    break;

                default:
                    if (ch!=0) {
                        System.out.println("!!! Enter valid input as per above !!!");
                    }

                break;
            }
        } while (ch!=0);
    }

    void showAllTeam() throws Exception{

        System.out.println();
        System.out.println("-----IPL Teams-----");
        String sql = "select team,team_name from team_details";
        ResultSet rs = pst.executeQuery(sql);
        System.out.println("Team\tTeam Name");
        System.out.println();

        while (rs.next()) {
            System.out.print(rs.getString(1)+"\t");
            System.out.println(rs.getString(2));
        }

    }

    void showTeamDetails() throws Exception{

        System.out.println();
        System.out.print("Teams :- ");
        String sql1 = "select team from team_details";
        ResultSet rs1 = pst.executeQuery(sql1);

        while (rs1.next()) {
            System.out.print(rs1.getString(1)+", ");
        }
        System.out.println();

        boolean temp;
        do {
            
            temp = true;
            System.out.println();
            System.out.print("Enter Team which details to show :- ");
            String t_name = sc.nextLine();
            String sql2 = "select team from team_details where team='"+t_name+"' ";
            ResultSet rs2 = pst.executeQuery(sql2);

            if (rs2.isBeforeFirst()) {
                System.out.println();
                String sql3 = "select team_name from team_details where team='"+t_name+"' ";
                ResultSet rs3 = pst.executeQuery(sql3);
                rs3.next();
                System.out.println("------Team : "+rs3.getString(1)+"------");

                String sql = "select player_name,player_type from player_details where team_name='"+t_name+"' ";
                ResultSet rs = pst.executeQuery(sql);
                System.out.println("Player Name\t\tPlayer Type");
                System.out.println();
                while (rs.next()) {
                    System.out.print(rs.getString(1)+"\t\t");
                    System.out.println(rs.getString(2));
                }

                temp = false;

            }else{
                System.out.println("Team not found, try again !!");
            }

        } while (temp);
    }

    void addPlayer()throws Exception{

        System.out.println("Enter player name : ");
        String name = sc.nextLine();
        System.out.println("Enter player type : ");
        String type = sc.nextLine();
        System.out.println("Enter team name : ");
        String teamName = sc.nextLine();
        System.out.println("Enter base price : ");
        String basePrice = sc.nextLine();
        System.out.println("Enter is_available : ");
        String available = sc.nextLine();

        String q = "insert into player_details(player_name,player_type,team_name,base_price,is_available) values (?,?,?,?,?)";
        pst = dc.con.prepareStatement(q);
        pst.setString(1,name);
        pst.setString(2,type);
        pst.setString(3,teamName);
        pst.setString(4,basePrice);
        pst.setString(5,available);
        pst.executeUpdate();

    }

    void addTeam()throws Exception{

        System.out.println("Enter team name : ");
        String teamName = sc.nextLine();
        System.out.println("Enter short name : ");
        String name = sc.nextLine();

        String q = "insert into team_details(team_name,team) values (?,?)";
        pst = dc.con.prepareStatement(q);
        pst.setString(1,teamName);
        pst.setString(2,name);
        pst.executeUpdate();

    }

    void deletePlayer()throws Exception{

        System.out.println("Enter player name : ");
        String delPlayerName = sc.nextLine();

        String q = "delete from player_details where player_name = ?";
        pst = dc.con.prepareStatement(q);
        pst.setString(1,delPlayerName);
        pst.executeUpdate();

    }

    void deleteTeam()throws Exception{

        System.out.println("Enter Team name : ");
        String delTeamName = sc.nextLine();

        String q = "delete from team_details where team_name = ?";
        pst = dc.con.prepareStatement(q);
        pst.setString(1,delTeamName);
        pst.executeUpdate();
    }

    void playerNotInTeam() throws Exception{

        System.out.println();
        System.out.println("\t\t-----List of Player who not in a team-----");
        String sql = "select player_id,player_name,player_type,base_price from player_details where is_available = 1";
        pst = dc.con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        System.out.println("player_id\tbase_price(in Cr.)\tplayer_name\tplayer_type");
        System.out.println();
        while (rs.next()) {
            
            System.out.print(rs.getInt(1) +"\t\t\t");
            System.out.print(rs.getInt(4) +"\t\t");
            System.out.print(rs.getString(2) +"\t");
            System.out.println(rs.getString(3) +"\t");

        }

    }

    void adminList() throws Exception{

        System.out.println();
        System.out.println("\t-----Admin List-----");
        String sql = "select id_number,name from login_details";
        ResultSet rs = pst.executeQuery(sql);
        System.out.println("Admin ID\tAdmin Name");
        System.out.println();
        while (rs.next()) {
            System.out.print(rs.getInt(1)+"\t\t");
            System.out.println(rs.getString(2));
        }

    }

    void winList() throws Exception{

        System.out.println();
        System.out.println("\t---IPL Winnings---");
        String sql = "SELECT * FROM win_details";
        ResultSet rs = pst.executeQuery(sql);
        System.out.println("Year\tTeam Name");
        System.out.println();
        while (rs.next()) {
            System.out.print(rs.getInt(2)+"\t");
            System.out.println(rs.getString(1));
        }

    }

    public static void main(String[] args) throws Exception{

        IPLAuction ia = new IPLAuction(); // IPLAuction(main class) object to call different class method..
        // Above object also use to initialize DBConnect object..

        for(;;){

            System.out.println();
            System.out.println("-----Verify Your Identity-----");
            System.out.print("Enter your id card number :- ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your name :- ");
            String name = sc.nextLine();

            if (ia.checkIdentity(id, name)) {
                break;
            }else{
                System.out.println("Identity not matched, try again !!");
            }

        }
        System.out.println();
        System.out.println("-----Welcome To IPL Auction 2024-----");
        int ch;

        do {

            System.out.println();
            System.out.println("\tHome");
            System.out.println("- For Auction a Player(1)\n- Show IPL Details(2)\n- Close Application(0)");
            System.out.print("Enter choice :- ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    ia.AuctionPlayer();
                    break;

                case 2:
                    ia.AuctionDetails();
                    break;

                default:if (ch!=0) {
                    System.out.println("Enter valid input choice !!");
                }
                    break;
            }

        } while (ch!=0);
    }
}
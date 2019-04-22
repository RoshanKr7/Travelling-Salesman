/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class TravellingSalesman {

    static Graph g = new Graph();
    static int NumberOfEdge;
    static int NumberOfCity;
    static int numberOfExpand =0 ;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner (System.in);
        String C ;
        /////////////////////////////////////////////////////////////////////
        do{
            System.out.println("Enter input File name ");
            System.out.println("* KSA");
            System.out.println("* Turkey");
            System.out.println("* Australia");
         C = read.next();
          
        } while ((!C.equalsIgnoreCase("KSA")) && (!C.equalsIgnoreCase("Turkey")) && (!C.equalsIgnoreCase("Australia"))) ;
        
        /////////////////////////// Greedy Search ///////////////////////////
        ArrayList<City> TravellingList = GreedySearch(C);
        Object[] TravellingCity = TravellingList.toArray();
        System.out.print("Shortest path using Greedy search algorithm is : \n");
        for (int i = 0; i < TravellingCity.length; i++) {
            System.out.print(((City) TravellingCity[i]).getLebal() + " ");

        }
        System.out.println("");
        System.out.println("Number of cites explored: " + numberOfExpand);
        g.makeunvisited();
        ////////////////////////////////////////////////////////////////////

        if (C.equalsIgnoreCase("KSA")){
            System.out.println("This algorithm can't handle a huge input data for this problem");}
        else {
        String sc = UuniformCostSearch(C);

        String[] TravellingCityC = sc.split("-");
        System.out.print("Shortest path using uniform cost search algorithm is : \n");
        for (int i = TravellingCityC.length - 1; i >= 0; i--) {
            System.out.print((TravellingCityC[i]) + " ");
            
        }
         System.out.println("");
         System.out.println("Number of cites explored: " + numberOfExpand);
        }
       
        g.makeunvisited();
        /////////////////////////////////////////////////////////////////////
        if (C.equalsIgnoreCase("KSA")){
            System.out.println("This algorithm can't handle a huge input data for this problem");}
        else {
        String s = Astar(C);

        String[] TravellingCityS = s.split("-");
        System.out.print("Shortest path using A* search algorithm is : \n");
        for (int i = TravellingCityS.length - 1; i >= 0; i--) {
            System.out.print((TravellingCityS[i]) + " ");

        } 
         System.out.println("");
         System.out.println("Number of cites explored: " + numberOfExpand);
        }
        g.makeunvisited();
    }

    public static void ReadGraph(String FileName) throws FileNotFoundException {
        File inputFile = new File(FileName+".in");
        if (!inputFile.exists()) {
            System.out.println("not exists");
            System.exit(0);
        }// check if file exists or not .
        // read from input file , write in outputFile .  
        Scanner input = new Scanner(inputFile);
        int index = 0;
        NumberOfCity = input.nextInt();
        NumberOfEdge = input.nextInt();
        g.setNv(NumberOfCity);
        while (input.hasNext()) {
            String command = input.next();

            switch (command) {
                case "Add_City":

                    for (int i = 0; i < NumberOfCity; i++) {
                        String City = input.next();
                        int Heuristic = input.nextInt();
                        g.AddCity(City, Heuristic, index);
                        index++;
                    }

                    break;
                case "Add_Adjacent":

                    for (int i = 0; i < NumberOfEdge; i++) {
                        int City1 = input.nextInt();
                        int City2 = input.nextInt();
                        int dist = input.nextInt();
                        g.AddEdge(City1, City2, dist);
                    }

                    break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    static ArrayList<City> GreedySearch(String FileName) throws FileNotFoundException {
        ReadGraph( FileName);
        numberOfExpand = 0;
        ///////////////////////////////////////////////////////////
        VList Frontier = new VList(); // To store selecte city  
        VList ExploredSet = new VList(); // To store next city 
        ArrayList<City> VisitedCities = new ArrayList(); // To store visited cities
        //////////////////////////////////////////////////////////

        Frontier.insertVertex(g.Cities[0]); // Add first city into frontier list
        g.Cities[0].setVisit(true); // Make first city visit

        /////////////////////////////////////////////////////////
        do {

            City v = Frontier.FirstVertex();  // Delete first city from Frontier list and stored on new variable
            VisitedCities.add(v); // Add v to list of visited cities

            ////////////////////////////////////////////////////////////
            // Check if visit all cities on graph return travelling list
            if (g.AllGraphVisit()) {
                VisitedCities.add(g.getCity(0));
                return VisitedCities; // return travelling list
            }
            /////////////////////////////////////////////////////////////

            // Array of string to store adjacent cities of city v
            String[] AdjacentList = v.adjacent.AdjacentList().split("-"); // return list of adjacent cities 

            for (int i = 0; i < AdjacentList.length; i++) {
                City EdgeCity = g.getCity(Integer.parseInt(AdjacentList[i]));

                // Check if EdgeCity not visited and not exisit on Explored set
                if ((EdgeCity.isVisit() == false) && (!ExploredSet.found(EdgeCity))) {
                    numberOfExpand++ ;
                    ExploredSet.insertVertex(EdgeCity);
                }
            }
            //////////////////////////////////////////////////////////////

            // Delete first city from Explored Set and stored on new variable
            City vert = ExploredSet.FirstVertex();
            vert.setVisit(true); // Make city visit
            Frontier.insertVertex(vert); // Add city into frontier list

        } while (!(Frontier.isEmpty())); // check if Frontier is empty or not 

        return VisitedCities; // return travelling list 

    }

    //----------------------------------------------------------------------------------------------------------
     static String UuniformCostSearch( String FileName) throws FileNotFoundException {
        ReadGraph(FileName);
        numberOfExpand=0;
        ///////////////////////////////////////////////////////////
        ArrayList<Path> Frontier = new ArrayList(); // To store selecte city  
        ArrayList<Path> ExploredSet = new ArrayList(); // To store next city 
        ArrayList<Path> VisitedCities = new ArrayList(); // To store visited cities
        int TD = 0;
        int min;
        int index;
        //////////////////////////////////////////////////////////

        Frontier.add(new Path(g.Cities[0].getLebal(), 0)); // Add first city into frontier list
        g.Cities[0].setVisit(true); // Make first city visit

        /////////////////////////////////////////////////////////
        do {

            Path v = Frontier.remove(0); // Delete first city from Frontier list and stored on new variable
            VisitedCities.add(v); // Add v to list of visited cities

            ////////////////////////////////////////////////////////////
            // Check if visit all cities on graph return travelling list
            String[] s = v.getSeqPath().split("-");
            if (s.length == NumberOfCity + 1 && s[s.length - 1].equals(g.getCity(0).getLebal())) {

                return v.getSeqPath(); // return travelling list
            }
            /////////////////////////////////////////////////////////////

            // Array of string to store adjacent cities of city v
            String LastCity = v.FirstCity();
            ArrayList AdjacentList = g.getCity(LastCity).adjacent.tr();
            //String[] AdjacentList = v.adjacent.AdjacentList().split("-"); // return list of adjacent cities 

            for (int i = 0; i < AdjacentList.size(); i++) {
                TD = 0;
                City EdgeCity = g.getCity((int) AdjacentList.get(i));
                //System.out.println(EdgeCity.getLebal());
                int costP = EdgeCity.adjacent.getDistance((g.findCity(LastCity)));
                // System.out.println(EdgeCity.getLebal()+" "+LastCity);    
                // Check if EdgeCity not visited and not exisit on Explored set
                if ((!v.getSeqPath().contains(EdgeCity.getLebal()) || EdgeCity.isVisit() == false)) {
                    ExploredSet.add(new Path((EdgeCity.getLebal() + "-" + v.getSeqPath()),
                            (TotalDis(v) + costP)));
                    numberOfExpand++;

                }
                if ((v.getSeqPath().split("-").length == NumberOfCity)) {
                  
                    g.getCity(0).setVisit(false);

                }
            }

            min = ExploredSet.get(0).getTotalDistance();

            index = 0;
            for (int i = 0; i < ExploredSet.size(); i++) {

                if (min > ExploredSet.get(i).getTotalDistance()) {
                    min = ExploredSet.get(i).getTotalDistance();

                    index = i;
                }
            }
            //System.out.println(ExploredSet.get(index).getTotalDistance() + " "+ExploredSet.get(index).getSeqPath());
            // Delete first city from Explored Set and stored on new variable
            Path vert = ExploredSet.remove(index);

            g.Cities[g.findCity(vert.FirstCity())].setVisit(true);
            Frontier.add(new Path(vert.getSeqPath(), vert.getTotalDistance())); // Add city into frontier list
            //System.out.println(Frontier.get(Frontier.size()-1).getSeqPath());

            //////////////////////////////////////////////////////////////
        } while (!(Frontier.isEmpty())); // check if Frontier is empty or not 

        return null; // return travelling list 
    }

     static String Astar(String FileName) throws FileNotFoundException {
        numberOfExpand= 0;
        ReadGraph(FileName);
        ///////////////////////////////////////////////////////////
        ArrayList<Path> Frontier = new ArrayList(); // To store selecte city  
        ArrayList<Path> ExploredSet = new ArrayList(); // To store next city 
        ArrayList<Path> VisitedCities = new ArrayList(); // To store visited cities
        int TD = 0;
        int min;
        int index;
        //////////////////////////////////////////////////////////

        Frontier.add(new Path(g.Cities[0].getLebal(), g.Cities[0].getHeuristic())); // Add first city into frontier list
        g.Cities[0].setVisit(true); // Make first city visit

        /////////////////////////////////////////////////////////
        do {

            Path v = Frontier.remove(0); // Delete first city from Frontier list and stored on new variable
            VisitedCities.add(v); // Add v to list of visited cities

            ////////////////////////////////////////////////////////////
            // Check if visit all cities on graph return travelling list
            String[] s = v.getSeqPath().split("-");
            if (s.length == NumberOfCity + 1 && s[s.length - 1].equals(g.getCity(0).getLebal())) {

                return v.getSeqPath(); // return travelling list
            }
            /////////////////////////////////////////////////////////////

            // Array of string to store adjacent cities of city v
            String LastCity = v.FirstCity();
            ArrayList AdjacentList = g.getCity(LastCity).adjacent.tr();
            //String[] AdjacentList = v.adjacent.AdjacentList().split("-"); // return list of adjacent cities 

            for (int i = 0; i < AdjacentList.size(); i++) {
                TD = 0;
                City EdgeCity = g.getCity((int) AdjacentList.get(i));
                int costP = EdgeCity.adjacent.getDistance((g.findCity(LastCity)));
                // Check if EdgeCity not visited and not exisit on Explored set
                if ((!v.getSeqPath().contains(EdgeCity.getLebal()) || EdgeCity.isVisit() == false)) {
                    ExploredSet.add(new Path((EdgeCity.getLebal() + "-" + v.getSeqPath()),
                            (TotalDis(v) + costP + EdgeCity.getHeuristic())));
                    numberOfExpand++;

                }
                if ((v.getSeqPath().split("-").length == NumberOfCity)) {
                    g.getCity(0).setVisit(false);

                }
            }

            min = ExploredSet.get(0).getTotalDistance();

            index = 0;
            for (int i = 0; i < ExploredSet.size(); i++) {

                if (min > ExploredSet.get(i).getTotalDistance()) {
                    min = ExploredSet.get(i).getTotalDistance();

                    index = i;
                }
            }
            // Delete first city from Explored Set and stored on new variable
            Path vert = ExploredSet.remove(index);

            g.Cities[g.findCity(vert.FirstCity())].setVisit(true);
            Frontier.add(new Path(vert.getSeqPath(), vert.getTotalDistance())); // Add city into frontier list

            //////////////////////////////////////////////////////////////
        } while (!(Frontier.isEmpty())); // check if Frontier is empty or not 

        return null; // return travelling list 
    }

    public static int TotalDis(Path p) {
        String[] cities = p.getSeqPath().split("-");
        int totalDis = 0;
        for (int i = 0; i < cities.length - 1; i++) {
            int city1 = g.findCity(cities[i]);
            int city2 = g.findCity(cities[i + 1]);
            totalDis = totalDis + g.Cities[city1].adjacent.getDistance(city2);

        }
        return totalDis;

    }

}

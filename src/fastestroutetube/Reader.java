/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestroutetube;

import fastestroutetube.Dijkstra.Edge;
import fastestroutetube.Dijkstra.Vertex;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author micael
 */
public class Reader {

    private FileInputStream file;
    private Workbook workbook;
    private Sheet sheet;

    public Reader(String path) {
        try {
            file = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (FileNotFoundException e) {
            System.out.print("File wasn't found, terminating the program");
            System.exit(0);
        } catch (IOException e) {
            System.out.print("Problem with the file, terminating the program");
            System.exit(0);
        }
    }

    public Map<Edge, Vertex[]> getStations() {
       Map<Edge, Vertex[]> stations = new HashMap<>();
        Iterator<Row> iteratorRow = sheet.iterator();

        while (iteratorRow.hasNext()) {
            Row row = iteratorRow.next();
            String stationName = row.getCell(1).getStringCellValue();
            /*If row has only two cells we know it only holds a station so we
            can store the station if station is not stored already
             */
            if (row.getLastCellNum() == 2 && !stations.containsKey(new Station(stationName))) {
                stations.put(new Edge(stationName),getConnections(stationName));
            }
        }
        return stations;
    }

    public Vertex[] getConnections(String edge) {
        Iterator<Row> iteratorRow = sheet.iterator();
        Vertex[] connections = new Connection[getNoTies(edge)];
                                    int count =0;

        while (iteratorRow.hasNext()) {
            Row row = iteratorRow.next();
            /*If the row has 4 cells we know it contains a line, starting station,
            end station, end station and time taken between stations */
            if (row.getLastCellNum() == 4) {
                String source = row.getCell(1).getStringCellValue();
                String destination = row.getCell(2).getStringCellValue();
                if (source.equalsIgnoreCase(edge)) {
                    int time = (int) row.getCell(3).getNumericCellValue();
                    LineName lineName = LineName.getLineName(row.getCell(0).getStringCellValue());
                    connections[count] = new Connection(lineName, destination, source, time);
                    count++;
                }else if (destination.equalsIgnoreCase(edge)) {
                    int time = (int) row.getCell(3).getNumericCellValue();
                    LineName lineName = LineName.getLineName(row.getCell(0).getStringCellValue());
                    connections[count] = new Connection(lineName, source, destination, time);
                    count++;
                }
            }
        }
        return connections;
    }

    private int getNoTies(String edge) {
        int noOfTies=0;
        Iterator<Row> iteratorRow = sheet.iterator();
        while (iteratorRow.hasNext()) {
            Row row = iteratorRow.next();
            if (row.getLastCellNum() == 4) {
                String source = row.getCell(1).getStringCellValue();
                String destination = row.getCell(2).getStringCellValue();
                if (source.equalsIgnoreCase(edge)) {
                    noOfTies++;
                }else
                if(destination.equalsIgnoreCase(edge)){
                    noOfTies++;
                }
            }
         }
        return noOfTies;
    }
}

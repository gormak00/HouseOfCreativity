package controller;

import model.Child;
import model.ChildStatus;
import model.Groups;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExtraController {
    private ChildStatusController childStatusController;
    private ChildController childController;
    private List<ChildStatus> childStatusList;
    private List<Integer> childIdByDateList;
    private List<Child> allChildrenByIdList;
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

    public List<Child> createChildGroupByDateTable(Date date, int groupNumber) throws IOException, SQLException, ParseException {
        childStatusController = new ChildStatusController();
        childController = new ChildController();
        childStatusList = new ArrayList<>();
        childStatusList = childStatusController.getAllChildrenByGroup(groupNumber);
        System.out.println(childStatusList.size());
        createChildIdByDateList(date);
        allChildrenByIdList = new ArrayList<>();
        allChildrenByIdList = childController.getAllChildrenById(childIdByDateList);
        System.out.println(allChildrenByIdList.size());
        System.out.println(childIdByDateList.size());
        return allChildrenByIdList;
    }

    private void createChildIdByDateList(Date date) throws ParseException {
        childIdByDateList = new ArrayList<>();
        for (ChildStatus currentChS: childStatusList) {
            Date chSStartDate = formatter.parse(currentChS.getStart_date());
            Date chSEndDate = null;
            if(currentChS.getEnd_date() != null) chSEndDate = formatter.parse(currentChS.getEnd_date());
            if(chSStartDate.getTime() < date.getTime() && (chSEndDate == null || chSEndDate.getTime() > date.getTime())){
                childIdByDateList.add(currentChS.getChild_id());
            }
        }
    }
}

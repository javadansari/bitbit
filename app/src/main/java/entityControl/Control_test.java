package entityControl;

import java.util.ArrayList;
import java.util.List;

import entity.Result;
import entity.Value;
import entity.tbl.tbl_test;

/**
 * Created by Javad Ansari on 4/6/2017.
 */

public class Control_test {

    public Result.Entity_ServiceResult<ArrayList <tbl_test.entity>> selectTest(Value.Entity_ServiceValue<tbl_test.post> v)
    {


        Result.Entity_ServiceResult<ArrayList <tbl_test.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_test.entity>>();
        ArrayList<tbl_test.entity> ent = new ArrayList<tbl_test.entity>();

        for (int x=1;x<10 ; x++) {
           tbl_test.entity Tbl_test = new tbl_test().new entity() ;
            Tbl_test.setId(x);
            Tbl_test.setName("name"+x);

            ent.add(Tbl_test);
        }



        result.setM_Status(new Result().new Entity_ServiceStatus(true,""));
        result.setM_Result(ent);
        return result;
    }


}

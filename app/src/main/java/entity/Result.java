package entity;

import entity.tbl.tbl_test;

/**
 * Created by Javad Ansari on 3/18/2017.
 */

public class Result {

    public class Entity_ServiceResult<T> {


        private Entity_ServiceStatus m_Status;

        private T m_Result;

        public Entity_ServiceResult(Entity_ServiceStatus m_Status, T m_Result) {
            this.m_Status = m_Status;
            this.m_Result = m_Result;
        }

        public Entity_ServiceResult(){};

        public Entity_ServiceStatus getM_Status() {
            return m_Status;
        }

        public void setM_Status(Entity_ServiceStatus m_Status) {
            this.m_Status = m_Status;
        }

        public T getM_Result() {
            return m_Result;
        }

        public void setM_Result(T m_Result) {
            this.m_Result = m_Result;

        }

        public Entity_ServiceResult(tbl_test.entity tbl_test) {
            m_Status = new Entity_ServiceStatus();
        }

    }


    public class Entity_ServiceStatus {

        private boolean m_Success;

        private String m_Message;

        public Entity_ServiceStatus(boolean m_Success, String m_Message) {
            this.m_Success = m_Success;
            this.m_Message = m_Message;
        }

        public boolean isM_Success() {
            return m_Success;
        }

        public void setM_Success(boolean m_Success) {
            this.m_Success = m_Success;
        }

        public String getM_Message() {
            return m_Message;
        }

        public void setM_Message(String m_Message) {
            this.m_Message = m_Message;
        }

        //  Default to Fail status
        public Entity_ServiceStatus() {
            m_Success = false;
            m_Message = "Service Call failed";

        }


    }

}

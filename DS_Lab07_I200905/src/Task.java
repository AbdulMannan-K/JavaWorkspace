public class Task {

    private int taskId;
    private int executionTime;

    public Task(int taskId, int executionTime) {
        this.taskId=taskId;
        this.executionTime=executionTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }
}

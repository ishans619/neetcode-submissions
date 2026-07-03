class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int pre[] : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int completedCourses = 0;

        while(!q.isEmpty()){
            int currentCourse = q.poll();
            completedCourses++;

            for(int nextCourse : graph.get(currentCourse)){

                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0){
                    q.offer(nextCourse);    
                }
            }
        }

        return completedCourses == numCourses;
        
    }
}

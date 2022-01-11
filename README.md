# Initial setup
1.	Before you start verify that your local docker environment is started and your databases is available
2.	In a terminal (git bash on windows) clone the project.  “cd” into the project folder and delete the .git folder and do “your own” git init. 
3.	Chance the POM.xml file section: <project><properties><remote.server> to the address of tomcat manager on your own droplet
4.	Change the POM.xlm file section <project><properties><db.name> to your own “database name”
5.	On githib create 2 new secrets on the repository: REMOTE_USER and REMOTE_PW. The first should have of your of your tomcat user (from tomcat-users.xml file on digital ocean) and the second should have the password of the tomcat user
6.	Now you are ready for the next steps

# Deploy the project (manually) via Maven
1.	The user you have created on your droplet MySQL server, with GRANTS to all databases:
2.	On your droplet, either using workbench locally or via the SQL-client on the droplet, create a new database called “your database name”. ssh into your droplet, and navigate into the root of the cloned docker project 
3.	Check that your docker-compose.yml file has the right mysql credentials under the web section. Find the lines given below for USER, and PW
# exam_backend

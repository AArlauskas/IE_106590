Read me file for lab1.
Description of work:

Preparing:
1. Created lab folders (lab1,lab2,lab3)
2. Started working on lab1, with it's subparts (lab1.1, lab1.2 etc.)
3. Created repository for labs IE_106590
4. Installed Maven
5. Installed docker
6. Setting up GitKraken (tool for working with git)

Lab 1.1
1. Made sure that Maven is installed correctly.
2. Created a test project by changing the provided "maven generate" command to represent my naming scheme
f.e. artifactId, groupId.
3. Installed Intelij
4. Setting up VS Code

Lab 1.2
1. Looked into IPMA weather forecast API.
2. Installed necesary dependencies for Maven to work with provided source code.
3. Copied and adjusted provided source code to work with my project.
4. Installed aditional dependencies to provide the classes that were wising (GsonFactory).
5. Tested out created Maven project.

Lab 1.3
1. Created a new pull of the project to have it as my new working directory.
2. Looked into various new logging libraries.
3. On the base of previous project removed Console logging and added file logging for more persistent information.
4. Made sure that the commits were accurate and split into small parts.
5. Expanded the provided .gitignore file with the .log file, which is not necessary in the remote repository.

Lab 1.4
1. Installed and launched Docker
2. Completed the guide of setting up Docker on Windows.
3. Skipped Portainer, since Windows Docker already has a GUI for working with Docker.
4. Completed PostgreSql Docker guide and launced the database.
5. Tested out the database with Intelij's Database tool.
6. Tried to figure out how to set Docker project directory on Windows.
7. Completed the Docker tutorial compose exercise, splitted into two parts with two separate commits.

Lab 1.5
1. Looked into how to use Maven dependencies from another project.
2. Created IPMAApiClient project with the service, that is able to fetch data from the API based on the provided name.
3. Created a simple Maven application and added the dependencies.
4. Tested out the application to make sure that the results are correct.
5. Added exception handling for the new application.
6. Picked better libraries to make the Api calls.
7. Simplified the sollution to only work with maximum temperatures instead of city objects.
8. Added argument parsing for maven project as per requirements.

Review questions:
Q_A) Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.
A_A)
validate - validate the project is correct and all necessary information is available
compile - compile the source code of the project
test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
package - take the compiled code and package it in its distributable format, such as a JAR.
verify - run any checks on results of integration tests to ensure quality criteria are met
install - install the package into the local repository, for use as a dependency in other projects locally
deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.
These lifecycle phases (plus the other lifecycle phases not shown here) are executed sequentially to complete the default lifecycle. 

Q_B) Maven is a build tool; is it appropriate to run your project to?
A_B) Yes. Even though Maven is a build tool, it has a functionality built in to make it easier to use imported packages and plugins. Even though
it would be possible to do it without it, it would become much more taxing for the developer.

Q_C)What would be a likely sequence of Git commands required to contribute with a new feature to a
given project? (i.e., get a fresh copy, develop some increment, post back the added functionality)
A_C)
git clone URL_OF_REPOSITORY
git branch NEW_FEATURE_BRANCH
git checkout NEW_FEATURE_BRANCH
--after doing changes--
git commit -m "Descriptive message of changes"
git checkout master
git merge NEW_FEATURE_BRANCH

Q_D) There are strong opinions on how to write Git commit messages… Find some best practices online
and give your own informed recommendations on how to write good commit messages (in a team
project)
A_D) Git messages are supposed to be short and descriptive of the job done. Overall, git commits should be as small as possible,
so that the job done would be more easily understood. Commit message should describe the task done. If tools like Jira are used,
it would be appropriate to also name the commit's with the implemented features.

Q_E) Docker automatically prepares the required volume space as you start a container. Why is it
important that you take an extra step configuring the volumes for a (production) database?
A_E) For production, stability and itegrity is important. This means that it would be better to configure the volumes manually,
to make sure that you know how the Docker container works and where it is stored. This assures less chances of something getting deleted
or changed, without being to roleback the changes.
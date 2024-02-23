#set($hash = '#')
${hash} Set up your Project on GitHub

${hash}${hash} Init GitHub repository

* Create Repository via the following [URL](https://github.com/new)
  * Set repository name to ${projectName} 
  * Set visibility of the project. Note: To use GitHub's container registry ghcr, either make your repository public or ensure that you have billing plan including access to ghcr. 
  * Set owner for this project which is either your GitHub account, or one of your GitHub organizations
  * __For simplicity reason, please do not add any other files such as a README, LICENSE, or .gitignore before pushing the maven project into this repo as decribed in the next steps.__
* On your local system execute the following commands in the project directory:
    ```
    git init
    git add .
    git commit -m "first commit"
    git branch -M main
    git remote add origin ${vcsRepository}
    ```
* Push changes to your GitHub repo using your favorite IDE.


${hash}${hash} Configure GitHub actions 

*   __Docker image:__

    * Make your repository public to use ghcr or ensure that you have billing plan including access to ghcr.
  
*   __Automatic dependencies updates via dependabot with changelog generation:__ 

    *   Create a personal access token (PAT) in developer settings, as described [here](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token) with `public_repo` access enabled.

    *   Set up a secret for GitHub actions called `MERGE_ME_SECRET` for the new repository as described [here](https://docs.github.com/en/actions/security-guides/encrypted-secrets?tool=webui#creating-encrypted-secrets-for-a-repository) that includes the generated PAT

*   To build a new release via GitHub actions enable write access for the  `GITHUB_TOKEN` as described [here](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/enabling-features-for-your-repository/managing-github-actions-settings-for-a-repository#configuring-the-default-github_token-permissions).


${hash}${hash} Using GitHub actions

We provide the following GitHub actions that are eithner started manually or automatically. To validate the actions start all actions with start option `manually`:  

*   [mavenBuild.yml](${vcsRepository}/actions/workflows/mavenBuild.yml):
    *   __Description:__ Builds the project after each push
    *   __Started:__ Automatically and manually   

*   [unreleased_changes.yml](${vcsRepository}/actions/workflows/unreleased_changes.yml):
    *   __Description:__ Automatically maintains a file containing noteworthy changes made since the last release. Noteworthiness is determined through use of [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).
    *   __Started:__ Automatically only

*   [newRelease.yml](${vcsRepository}/actions/workflows/newRelease.yml):
    *   __Description:__ Create a new release using maven via GitHub web page
    *   __Started:__ Manually only
    *   Please note that the first run might fail, because the link to the ghcr.io repository is automatically created, first time you try to access it. So, please run this action twice, as soon as you created the repo.
    *   Also adds unreleased changes to the changelog.


*   [autoMerge.yml](${vcsRepository}/actions/workflows/autoMerge.yml):
    *   __Description:__ Automatic merge of dependency updates with new patch or minor versions of dependencies from Dependabot. See https://github.com/ridedott/merge-me-action for more information.
    *   __Started:__ Automatically only

*   [dependabot.yml](${vcsRepository}/actions/workflows/dependabot.yml):
    *   __Description:__ Check for new dependencies and create a pull request
    *   __Started:__ Automatically only (each day)

${hash}${hash} Deployment 

In the following we assume a docker-swarm setup which is a typical starting point for clustering your container.
In addition, it can be easily run and maintained on your developing machine. 

${hash}${hash}${hash} Docker-Stacks

*   [developerStack.yml](deploy/developerStack.yml)
    *   Includes all required dependencies to run the application during development on your local machine

*   [docker-compose.yml](deploy/docker-compose.yml)
    *   Stack to run the application as stack in your production environment

${hash}${hash}${hash} Deploy Stack 

To deploy the stack, you can use the following command from your checkout directory. 
```shell
docker stack deploy --compose-file ./deploy/docker-compose.yml ${artifactId.toLowerCase()}
```

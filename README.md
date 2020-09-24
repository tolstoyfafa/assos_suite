[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)  [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/tolstoyfafa/assos_suite/publish%20backend%20&%20frontend%20docker%20images?label=publish%20docker%20images&style=flat-square&logo=docker)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/tolstoyfafa/assos_suite/BackendCI?label=backend%20build&style=flat-square&logo=java) ![GitHub Workflow Status](https://img.shields.io/github/workflow/status/tolstoyfafa/assos_suite/Slack%20Notification?label=Notification%20Slack&logo=slack)
 
  
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/tolstoyfafa/assos_suite) 
![GitHub release (latest SemVer)](https://img.shields.io/github/v/tag/tolstoyfafa/assos_suite)  

[![GitHub issues](https://img.shields.io/github/issues/tolstoyfafa/assos_suite)](https://github.com/tolstoyfafa/assos_suite/issues) [![GitHub issues-closed](https://img.shields.io/github/issues-closed/tolstoyfafa/assos_suite)](https://github.com/tolstoyfafa/assos_suite/issues?q=is%3Aissue+is%3Aclosed) [![GitHub forks](https://img.shields.io/github/forks/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/network)  
[![GitHub stars](https://img.shields.io/github/stars/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/stargazers) [![GitHub watchers](https://img.shields.io/github/watchers/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/watchers)

[![Twitter](https://img.shields.io/twitter/url?url=https%3A%2F%2Ftwitter.com%2FAssoSuite)](https://twitter.com/AssoSuite)  
[![Website shields.io](https://img.shields.io/website?up_color=green&up_message=URL&url=https%3A%2F%2Fadmin.assosuite.ovh%2F)](https://admin.assosuite.ovh)  

# AssoSuite

AssoSuite is a complete free, open source solution to manage assosiations.

### Main features:

* Manage personal / adherents
* Reports /  Statistics
* Manage fundraising 
* Automatized mailling service
* Manage events

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Installing
What things you need to install the software and how to install them

- clone the project
```bash 
git clone git@github.com:tolstoyfafa/assos_suite.git
```
The project provide two ways to install the project for development purpose, using docker and without docker.
#### Without Docker
You nee to install this technolgies

- node v12.18.3  [see](https://nodejs.org/en/)
- yarn v1.2.5 [see](https://yarnpkg.com/)
- Openjdk 11 [see](https://jdk.java.net/java-se-ri/11)
- maven v3.6 [see](https://maven.apache.org/download.cgi)
- mongo 4.2   [see](https://docs.mongodb.com/manual/release-notes/4.2/)

Assosuite contains 2 components `backend` and `frontend`

To get a development env running you should follow each component documentation.
- [backend](backend/README.md)
- [frontend](frontend/README.md)

#### Using Docker
If you want to use Docker to get a developpement environment:

- copy .env-dev.sample and rename it to .env (change it depending on your environement) 

- in assosuite root directory run 
```bash
docker-compose up -d
```
You'll have 4 running containers:
 	- backend
	- frontend
	- mongo
	- mail
> You can find more information about our mail server configuration [here](https://github.com/tomav/docker-mailserver)

> you should have a basic knowledge about docker and docker compose to better utilisation
## Deployment
#### Requirements:
>  **NOTE:** You need a token to login in our github registry, it's a workaround, the images will be available in docker hub as soon as possible
> please contact us to get a token by sending a mail to AssoSuite@gmail.com

- A VM with docker and docker-compose installed
- A Domain Name with 2 address records (A) [see](https://docs.ovh.com/gb/en/domains/web_hosting_how_to_edit_my_dns_zone/) in order to have 2 subdomains that will be used by the frontend and backend.

Example:  
backend.organisation.com  
frontend.organisation.com

#### Instructions:

- copy `.env-prod-sample`, `docker-compose-prod.yml` `config-sample` to you deployment environment
- rename `.env-prof-sample` to `.env` and `docker-compose-prod.yml` to `docker-compose.yml` and `config-sample` to `config` 
or use this commands:
```bash
curl -o .env https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/.env-prod-sample
curl -o docker-compose.yml https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/docker-compose-prod.yml
mkdir config && cd config
curl -o dynamic.yaml https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/config-sample/dynamic.yaml
curl -o nginx.conf https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/config-sample/nginx.conf 

```
- the config directory contains nginx server configuration that you can customize as you wish,  and `dynamic.yaml` file used to redirect http traefik to https

- you can follow this documentation to use Gmail SMTP and get the required credentials
https://support.cloudways.com/configure-gmail-smtp/
> *WORKAROUND:* for now we are using gmail smtp server, you'll be able to use another provider in the next release version

- set your local settings in the .env (read the comments on the [env-prod-sample](.env-prod-sample) file)

> **NB**: To enable https we are using Let's encrypt see [documentation](https://docs.traefik.io/v1.7/user-guide/docker-and-lets-encrypt/)

- Then at last just execute this command to get a running production environment:
```bash
docker-compose up -d 
```

## Contributing
Please read [CONTRIBUTING.md](CONTRIBUTING.md)

## Versioning

Git

## Authors

* **BORDJAH Fayçal** - [fayçal Bordjah](https://github.com/tolstoyfafa)
* **EL HITARY Marouane** - [Marouane El hitary](https://github.com/MarOuanEElHiTaRY)

See also the list of [contributors](https://github.com/tolstoyfafa/assos_suite/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgement 
A special thanks to [Hiren PATEL](https://github.com/hirenpatelfr) and [Jackques ATACAN](https://github.com/atacanjacques?tab=followers) for they helps on the project

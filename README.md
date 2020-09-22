[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  
![publish docker images](https://github.com/tolstoyfafa/assos_suite/workflows/publish%20backend%20&%20frontend%20docker%20images/badge.svg)  
![Backend CI](https://github.com/tolstoyfafa/assos_suite/workflows/BackendCI/badge.svg)   
  
[![GitHub issues](https://img.shields.io/github/issues/tolstoyfafa/assos_suite)](https://GitHub.com/Naereen/StrapDown.js/issues/)  
[![GitHub issues-closed](https://img.shields.io/github/issues-closed/tolstoyfafa/assos_suite)](https://github.com/tolstoyfafa/assos_suite/issues?q=is%3Aissue+is%3Aclosed)     
[![GitHub release](https://img.shields.io/github/release/Naereen/StrapDown.js.svg)](https://github.com/tolstoyfafa/assos_suite/releases)      
[![GitHub tag](https://img.shields.io/github/tag/Naereen/StrapDown.js.svg)](https://github.com/tolstoyfafa/assos_suite/tags)  

[![GitHub forks](https://img.shields.io/github/forks/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/network)  
[![GitHub stars](https://img.shields.io/github/stars/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/stargazers)  
[![GitHub watchers](https://img.shields.io/github/watchers/tolstoyfafa/assos_suite?style=social)](https://github.com/tolstoyfafa/assos_suite/watchers)  
![Tweeting](https://img.shields.io/twitter/url?url=https%3A%2F%2Ftwitter.com%2FAssoSuite)    
[![Website shields.io](https://img.shields.io/website?up_color=green&up_message=URL&url=https%3A%2F%2Fadmin.assosuite.ovh%2F)](https://admin.assosuite.ovh)  

# AssoSuite

AssoSuite is a complete free, open source solution to manage assosiations.
### Main features:

* Manage personal / adherents
* Reports /  Statistics
* Manage fundraising 
* Automtised mailling service
* Manage events

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Installing
What things you need to install the software and how to install them

- clone the project

#### without Docker

- node v12.18.3 
- yarn v1.2.5
- Openjdk 11
- maven v3.6
- mongo 4.2  

Assosuite contains 2 components `backend` and `frontend`

To get a development env running you should follow each component documentation.
- [backend](backend/README.md)
- [frontend](frontend/README.md)

#### Using Docker
If you want to use Docker to get a developpement environment:

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
- A VM with docker and docker-compose installed
- A Domain Name with 2 address records (A) [see](https://docs.ovh.com/gb/en/domains/web_hosting_how_to_edit_my_dns_zone/) in order to have 2 subdomains that will be used by the frontend and backend.

Example:  
backend.organisation.com  
frontend.organisation.com

#### Instructions:

- copy `.env-prod-sample`, `docker-compose-prod.yml` `config-sample` to you deployment environment
or use this command:
```bash
curl -o .env https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/.env-prod-sample

curl -o docker-compose.yml https://raw.githubusercontent.com/tolstoyfafa/assos_suite/master/docker-compose-prod.yml

```
- rename `.env-prof-sample` to `.env` and `docker-compose-prod.yml` to `docker-compose.yml` and `config-sample` to `config` 
> the config directory contains nginx server configuration that you can customize as you wish,  and `dynamic.yaml` file used to redirect http traefik to https
#### mail server configuration:
you can follow this documentation to use Gmail SMTP 
https://support.cloudways.com/configure-gmail-smtp/
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

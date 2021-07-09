# Docker Environment Settings

## How to Install Docker on Windows

```make
Docker Toolbox for Windows는 Virtual Box를 사용하며 Windows 10 Pro의 경우 Hyper-V 기능을 해제해야 한다.

1. 제어판 -> 프로그램 -> 프로그램 및 기능 그룹의 Windows 기능 켜기/끄기 클릭
2. Hyper-V 기능에 체크가 해제되어 있는지 확인
3. 이후 컴퓨터를 다시 시작하여 Hyper-V 기능을 무효화한다.
4. https://docs.docker.com/toolbox/toolbox_install_windows/ 를 참고하여 설치를 진행한다.
   (Docker Toolbox for Windows 설치)
5. Docker 설치시 Docker Compose for Windows 와 VirtualBox를 선택하고
   Git for Windows는 선택하지 않도록 한다.
6. Docker 구동 이후 docker version 및 docker-compose version
   혹은 docker-machine version 명령이 잘 구동되어야 한다.
```

## How to Install Vagrant on Windows

```make
Vagrant 다운로드 페이지에서 다운 받도록 한다.
(https://www.vagrantup.com/downloads.html)에서 msi로 다운로드하여 실행한다.
```

## How to Install Chocolatey

```make
Windows에 curl을 설치하기 위해 사용한다.
Linux의 apt나 yum, MAC의 brew에 해당한다.
우리의 케이스에서는 nodejs 덕분에 아마 설치 되어있을 것이다.

cinst
```

## How to Install curl & kubectl

Chocolatey를 사용하여 curl과 kubectl을 설치한다.  

```make
cinst -y curl kubernetes-cli
```

아래와 같이 설치한 패키지를 확인할 수 있다.  

```make
choco list -lo
```

## How to Install minikube

```make
cinst -y minikube
```

## VirtualBox Upgrade

VirtualBox를 최신 버전으로 업데이트한다.

```make
1. Oracle VM VirtualBox 관리자를 기동하여 파일 -> 업데이트 찾기 클릭
2. 새로운 버전 업데이트가 나타나면 링크를 클릭하여 설치 파일을 다운로드하고 업데이트
```

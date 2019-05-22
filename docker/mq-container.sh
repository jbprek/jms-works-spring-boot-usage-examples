#Create IBM MQ container
#TODO Fix
docker run ‑‑env LICENSE=accept ‑‑env MQ_QMGR_NAME=QM1 \
           --name ibm-mq-boot\
           ‑‑publish 1414:1414 \
           ‑‑publish 9443:9443 \
           ‑‑detach \
           ibmcom/mq
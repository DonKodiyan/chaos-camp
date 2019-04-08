#!/bin/bash


echo "download toxyproxy package"
wget -O toxiproxy-2.1.4.deb https://github.com/Shopify/toxiproxy/releases/download/v2.1.4/toxiproxy_2.1.4_amd64.deb

echo "install toxiproxy package"
sudo dpkg -i toxiproxy-2.1.4.deb

echo "copying toxiproxy.service to system folder"
sudo cp toxiproxy.service /etc/systemd/system/

echo "reload config"
sudo systemctl daemon-reload

echo "Check status"
sudo systemctl status toxiproxy.service

echo "start service"
sudo systemctl start toxiproxy.service

echo "Check status"
sudo systemctl status toxiproxy.service
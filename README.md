# haproxy testing

sudo haproxy -f haproxy.cfg

## Follow 302 redirects to HTTPs version from HTTP version
curl -L -k -v http://localhost:80/api/test

## Use HTTPs version
curl -k -v https://localhost/api/test


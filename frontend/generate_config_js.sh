#!/bin/sh -eu

#echo -e "window.REACT_APP_API_URL='${API_URL}';\n window.REACT_APP_PORT='{API_PORT}'";
cat <<EOF
window.REACT_APP_API_URL='${API_URL}';
window.REACT_APP_API_PORT='${API_PORT}';
EOF


from http.server import BaseHTTPRequestHandler, HTTPServer
class Handler(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200); self.send_header('Content-Type','application/json'); self.end_headers(); self.wfile.write(b'{"service":"nexuslegal-notifications","status":"ready"}')
    def do_POST(self):
        length=int(self.headers.get('Content-Length','0')); self.rfile.read(length); self.send_response(202); self.send_header('Content-Type','application/json'); self.end_headers(); self.wfile.write(b'{"accepted":true}')
HTTPServer(('0.0.0.0',8090),Handler).serve_forever()

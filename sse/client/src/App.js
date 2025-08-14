import { Box, Container } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [accessEvent, setAccessEvent] = useState([]);

  useEffect(() => {
    const eventSource = new EventSource(
      "http://localhost:8080/api/sse/subscribe"
    );

    eventSource.addEventListener("connect", (event) => {
      console.log(event.data);
    });

    eventSource.addEventListener("access", (event) => {
      setAccessEvent((prev) => [...prev, { ...JSON.parse(event.data) }]);
    });
  }, []);

  const eventColumns = [
    { field: "id", headerName: "ID", width: 250 },
    { field: "name", headerName: "명칭", width: 250 },
    { field: "occurredAt", headerName: "시간", width: 350 },
  ];

  return (
    <div className="App">
      <Container maxWidth="lx" sx={{ mt: 5 }}>
        <h1>📝 Access Event List</h1>
        <Box sx={{ height: 1000, mb: 4 }}>
          <DataGrid rows={accessEvent} columns={eventColumns} pageSize={5} />
        </Box>
      </Container>
    </div>
  );
}

export default App;

import {
  Table, TableBody, TableCell, TableContainer, TableHead, TableRow,
  Paper, TablePagination
} from "@mui/material";
import { ResultRow } from "src/pages/acquirertestpage/types/ResultRow";
import { useState } from "react";

interface ResultTableProps {
  rows: ResultRow[];
  page: number;
  rowsPerPage: number;
  totalRows: number;
  onPageChange: (newPage: number) => void;
}

export const ResultTable: React.FC<ResultTableProps> = ({
  rows,
  page,
  rowsPerPage,
  totalRows,
  onPageChange,
}) => {
  const handleChangePage = (_: unknown, newPage: number) => {
    onPageChange(newPage); // теперь вызываем внешний коллбэк
  };

  return (
    <Paper sx={{ mt: 0, maxWidth: 1000, mx: "auto" }}>
      <TableContainer>
        <Table size="small">
          <TableHead>
            <TableRow sx={{ '& th': { fontWeight: 'bold' } }}>
              <TableCell>#</TableCell>
              <TableCell>Дата и время отправки</TableCell>
              <TableCell>Request ID</TableCell>
              <TableCell>Trace ID</TableCell>
              <TableCell>Время доставки</TableCell>
              <TableCell>Body</TableCell>
              <TableCell>Error</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row, index) => (
              <TableRow key={index}>
                <TableCell>{page * rowsPerPage + index + 1}</TableCell>
                <TableCell>{new Date(row.sentAt).toLocaleString()}</TableCell>
                <TableCell>{row.requestId}</TableCell>
                <TableCell>{row.traceId}</TableCell>
                <TableCell>{row.deliveryTime}</TableCell>
                <TableCell>
                  <pre style={{ whiteSpace: "pre-wrap", wordBreak: "break-word" }}>
                    {row.body}
                  </pre>
                </TableCell>
                <TableCell>{row.error ?? "-"}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      <TablePagination
        component="div"
        count={totalRows}
        page={page}
        onPageChange={handleChangePage}
        rowsPerPage={rowsPerPage}
        onRowsPerPageChange={() => {}} // если не используешь — оставь пустым
        rowsPerPageOptions={[10]}
      />
    </Paper>
  );
};

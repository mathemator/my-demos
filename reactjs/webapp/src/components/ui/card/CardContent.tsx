import { CardContent as MUICardContent } from "@mui/material";
import { ReactNode } from "react";

export const CardContent = ({ children }: { children: ReactNode }) => (
  <MUICardContent sx={{ padding: 2 }}>
    {children}
  </MUICardContent>
);

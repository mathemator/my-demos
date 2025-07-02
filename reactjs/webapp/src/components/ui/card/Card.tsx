import { Card as MUICard, CardContent as MUICardContent } from "@mui/material";
import { ReactNode } from "react";

export const Card = ({ children }: { children: ReactNode }) => (
  <MUICard variant="outlined" sx={{ maxWidth: {
                                          xs: '90vw',  // на очень маленьких экранах максимум 90% ширины вьюпорта
                                          sm: '400px', // на маленьких и выше максимум 400px
                                          md: '600px', // на средних и выше 500px
                                          lg: '800px', // на больших и выше 600px
                                        }, borderRadius: 3, boxShadow: 3 }}>
    <MUICardContent>
      {children}
    </MUICardContent>
  </MUICard>
);
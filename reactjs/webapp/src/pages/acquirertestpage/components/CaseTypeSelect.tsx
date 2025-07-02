import React from "react";
import { Select, MenuItem, InputLabel, FormControl } from "@mui/material";
import { caseTypes } from "src/pages/acquirertestpage/constants/caseTypes";

interface CaseTypeSelectProps {
  value: string;
  onChange: (event: React.ChangeEvent<{ value: unknown }>) => void;
  label?: string;
  id?: string;
}

export const CaseTypeSelect: React.FC<CaseTypeSelectProps> = ({
  value,
  onChange,
  label = "Select Type",
  id = "caseType",
}) => {
  return (
    <FormControl fullWidth variant="outlined" size="small">
      <InputLabel id={`${id}-label`}>{label}</InputLabel>
      <Select
        labelId={`${id}-label`}
        id={id}
        value={value} // ← тут была ошибка: было caseType, надо value
        onChange={onChange}
        label="Тип кейса"
      >
        {caseTypes.map((ct) => (
          <MenuItem key={ct.id} value={ct.id}>
            {ct.id} - {ct.label}
          </MenuItem>
        ))}
      </Select>
    </FormControl>
  );
};

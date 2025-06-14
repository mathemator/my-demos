import { useState, useEffect } from "react";
import { updateResult } from "src/pages/acquirertestpage/api/updateResult";
import { sendRequest } from "src/pages/acquirertestpage/api/sendRequest";
import { TraceIdCard } from "src/pages/acquirertestpage/components/TraceIdCard";
import { StepsCard } from "src/pages/acquirertestpage/components/StepsCard";
import { MemberEsiaSection } from "src/pages/acquirertestpage/components/MemberEsiaSection";
import { ResultTable } from "src/pages/acquirertestpage/components/ResultTable";
import { CaseTypeSelect } from "src/pages/acquirertestpage/components/CaseTypeSelect";
import { generateTraceId } from "src/utils/trace";
import { MemberDto } from "src/types/MemberDto";
import { ResultRow } from "src/pages/acquirertestpage/types/ResultRow";

import { SelectChangeEvent } from "@mui/material";
import { Typography, Box } from "@mui/material";


export default function CaseListPage() {
  const [traceId, setTraceId] = useState("");
  const [showAllTraceIds, setShowAllTraceIds] = useState(false);
  const [memberId, setMemberId] = useState("");
  const [esiaId, setEsiaId] = useState("");
  const [caseType, setCaseType] = useState("");
  const [results, setResults] = useState<ResultRow[]>([]);
  const [step1Status, setStep1Status] = useState<"idle" | "success" | "error">("idle");
  const [pageInfo, setPageInfo] = useState({
    totalPages: 0,
    totalElements: 0,
    currentPage: 0,
    size: 10,
  });
  const [members, setMembers] = useState<MemberDto[]>([]);
  const [loadingMembers, setLoadingMembers] = useState(true);

  const isSubmitDisabled = (traceId.trim() === "" && !showAllTraceIds)
  || memberId.trim() === "" || esiaId.trim() === "" || caseType.trim() === "";

  const isRefreshDisabled = (traceId.trim() === "" && !showAllTraceIds);

  useEffect(() => {
    setStep1Status("idle");
  }, [memberId, esiaId, traceId, caseType]);

  const handleGenerate = () => {
    setTraceId(generateTraceId());
  };

  const handleSubmit = async () => {
    try {
      const response = await sendRequest({ memberId, esiaId, traceId });
      if (response.ok) {
        setStep1Status("success");
        await handleUpdate(); // обновляем таблицу
      } else {
        setStep1Status("error");
      }
    } catch (err) {
      console.error("Ошибка при отправке:", err);
      setStep1Status("error");
    }
  };

  const handleUpdate = async () => {
    try {
      const response = await updateResult(caseType, 0, 10, { memberId, esiaId, traceId });
      setResults(response.content); // сюда идёт только content
      setPageInfo({
        totalPages: response.page.totalPages,
        totalElements: response.page.totalElements,
        currentPage: response.page.number,
        size: response.page.size
      });
    } catch (error: any) {
      console.error("Ошибка при обновлении:", error.message);
    }
  };

  const handlePageChange = async (newPage: number) => {
    try {
      const response = await updateResult(caseType, newPage, pageInfo.size, {
        memberId,
        esiaId,
        traceId,
        page: newPage,
        size: pageInfo.size,
      });
      setResults(response.content);
      setPageInfo({
              totalPages: response.page.totalPages,
              totalElements: response.page.totalElements,
              currentPage: response.page.number,
              size: response.page.size
            });
    } catch (error) {
      console.error("Ошибка при пагинации:", error);
    }
  };

  const handleCaseTypeChange = (event: SelectChangeEvent) => {
    setCaseType(event.target.value);
  };

  return (
    <Box
      sx={{
        minHeight: "100vh",
        backgroundColor: "#f3f4f6", // bg-gray-100
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        padding: 2,
        gap: 2,
      }}
    >
      <Typography variant="h5" align="center" sx={{ color: "#1f2937", fontWeight: 600 }}>
        Тест-кейсы биоэквайрера
      </Typography>

      {/* Trace ID Section */}
      <Box sx={{ width: "100%", maxWidth: 800 }}>
      <div>
        <CaseTypeSelect
                        value={caseType}
                        onChange={handleCaseTypeChange}
                        id="caseType"
                        label="Выберите сценарий"
                      />
      </div>
      <StepsCard step1Status={step1Status} />

        <TraceIdCard
          traceId={traceId}
          setTraceId={setTraceId}
          showAllTraceIds={showAllTraceIds}
          setShowAllTraceIds={setShowAllTraceIds}
          onGenerate={handleGenerate}
          onUpdate={handleUpdate}
          isRefreshDisabled={isRefreshDisabled}
        />
      </Box>

      {/* Member ID and ESIA ID Section */}
      <MemberEsiaSection
        memberId={memberId}
        setMemberId={setMemberId}
        esiaId={esiaId}
        setEsiaId={setEsiaId}
        handleSubmit={handleSubmit}
        isSubmitDisabled={isSubmitDisabled}
      />
      <Box sx={{ width: "100%", maxWidth: 1200, mt: 4 }}>
        <ResultTable
          rows={results}
          page={pageInfo.currentPage}
          rowsPerPage={pageInfo.size}
          totalRows={pageInfo.totalElements}
          onPageChange={handlePageChange}
        />
      </Box>
    </Box>
  );
}

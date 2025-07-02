import { useEffect, useState } from "react";
import { MemberDto } from "src/types/MemberDto";

export function useMembers() {
  const [members, setMembers] = useState<MemberDto[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("/api/members")
      .then((res) => res.json())
      .then((data: MemberDto[]) => setMembers(data))
      .catch((err) => {
        console.error("Ошибка загрузки эквайреров:", err);
        setMembers([]);
      })
      .finally(() => setLoading(false));
  }, []);

  return { members, loading };
}

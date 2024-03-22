import { useContext } from "react";
import { CotizadorContext } from "../context/CotizadorProvider";

export const useCotizadorContext = () => {
  const context = useContext(CotizadorContext);
  if (context === undefined) {
    throw new Error(
      'CotizadorContext debe ser usado dentro de un CotizadorProvider'
    );
  }
  return context;
};

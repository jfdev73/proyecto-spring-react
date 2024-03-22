import { createContext, useContext, useState } from 'react';
import { diferenciaYear } from '../helpers';

export const CotizadorContext = createContext();

const initialDatos = {
	marca: '',
	year: '',
	plan: '',
};
const CotizadorProvider = ({ children }) => {
	const [datos, setDatos] = useState(initialDatos);

	const [error, setError] = useState('');

	const handleChangeDatos = e => {
		setDatos({
			...datos,

			[e.target.name]: e.target.value,
		});
	};

	const cotizarSeguro = () => {
		let resultado = 2000;
		const diferencia = diferenciaYear(datos.year);

		resultado -= diferencia * 0.03 * resultado;
		console.log({ resultado });
	};

	return (
		<CotizadorContext.Provider
			value={{ datos, handleChangeDatos, error, setError, cotizarSeguro }}
		>
			{children}
		</CotizadorContext.Provider>
	);
};

export default CotizadorProvider;

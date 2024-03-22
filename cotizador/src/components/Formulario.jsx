import { Fragment } from 'react';
import { MARCAS, PLANES, YEARS } from '../constants';
import { useCotizadorContext } from '../hooks/useCotizadorContext';
import Error from './Error';

const Formulario = () => {
	const { datos, handleChangeDatos, error, setError, cotizarSeguro } =
		useCotizadorContext();

	const handleSubmit = e => {
		e.preventDefault();
		if (Object.values(datos).includes('')) {
			setError('Todos los campos son obligatorios');
			return;
		}
		setError('');
		cotizarSeguro();
	};

	return (
		<>
			{error && <Error />}
			<form onSubmit={handleSubmit}>
				<div className='my-5'>
					<label
						htmlFor='marca'
						className='block mb-3 font-bold text-gray-400 uppercase'
					>
						Marca
					</label>
					<select
						name='marca'
						id='marca'
						className='w-full p-3 bg-white border border-gray-200'
						onChange={handleChangeDatos}
						value={datos.marca}
					>
						<option value=''>-- Selecciona Marca --</option>

						{MARCAS.map(marca => (
							<option value={marca.id} key={marca.id}>
								{marca.nombre}
							</option>
						))}
					</select>
				</div>

				<div>
					<label
						htmlFor='year'
						className='block mb-3 font-bold text-gray-400 uppercase'
					>
						Año
					</label>
					<select
						name='year'
						id='year'
						className='w-full p-3 bg-white border border-gray-200'
						onChange={handleChangeDatos}
						value={datos.year}
					>
						<option value=''>-- Selecciona Marca --</option>

						{YEARS.map(year => (
							<option value={year} key={year}>
								{year}
							</option>
						))}
					</select>
				</div>

				<div className='my-5'>
					<label
						htmlFor='plan'
						className='block mb-3 font-bold text-gray-400 uppercase'
					>
						Elige un Plan
					</label>
					<div className='flex gap-3 items-center'>
						{PLANES.map(plan => (
							<Fragment key={plan.id}>
								<label>{plan.nombre}</label>{' '}
								<input
									type='radio'
									name='plan'
									value={plan.id}
									onChange={handleChangeDatos}
								/>
							</Fragment>
						))}
					</div>
				</div>

				<input
					type='submit'
					className='w-full bg-indigo-500 hover:bg-indigo-600 transition-colors text-white cursor-pointer p-3 uppercase font-bold'
					value={'Cotizar'}
				/>
			</form>
		</>
	);
};
export default Formulario;
